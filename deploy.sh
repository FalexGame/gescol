#!/bin/bash
# ===================================================
# Script de despliegue automático - Proyecto Asistecia
# Spring Boot 4.0.6 + Java 17 + MySQL
# Uso: sudo bash deploy.sh
# ===================================================

set -e

APP_NAME="asistecia"
APP_DIR="/home/$SUDO_USER/$APP_NAME"
JAR_NAME="$APP_NAME-0.0.1-SNAPSHOT.jar"
DB_NAME="gescol"
DB_USER="root"
DB_PASS="1651"
SPRING_PORT="8080"

echo "========================================"
echo "  Despliegue Automático - $APP_NAME"
echo "========================================"

# 1. Actualizar sistema
echo "[1/7] Actualizando paquetes del sistema..."
apt update && apt upgrade -y

# 2. Instalar Java 17
echo "[2/7] Instalando Java 17..."
if ! java -version 2>&1 | grep -q "openjdk version \"17"; then
    apt install openjdk-17-jdk -y
fi
echo "Java: $(java -version 2>&1 | head -1)"

# 3. Instalar MySQL
echo "[3/7] Instalando MySQL..."
if ! command -v mysql &> /dev/null; then
    apt install mysql-server -y
    mysql_secure_installation
fi

# 4. Configurar base de datos
echo "[4/7] Configurando base de datos $DB_NAME..."
mysql -u root <<SQL
CREATE DATABASE IF NOT EXISTS $DB_NAME;
ALTER USER '$DB_USER'@'localhost' IDENTIFIED BY '$DB_PASS';
GRANT ALL PRIVILEGES ON $DB_NAME.* TO '$DB_USER'@'localhost';
FLUSH PRIVILEGES;
SQL

# 5. Compilar proyecto
echo "[5/7] Compilando proyecto con Maven..."
if [ ! -f "$APP_DIR" ]; then
    echo "ERROR: No se encuentra el proyecto en $APP_DIR"
    echo "Copia el proyecto a esa ruta y ejecuta el script de nuevo."
    exit 1
fi

cd "$APP_DIR"
chmod +x mvnw
./mvnw clean package -DskipTests -q

# 6. Crear servicio systemd
echo "[6/7] Configurando servicio systemd..."
SERVICE_FILE="/etc/systemd/system/$APP_NAME.service"

cat > "$SERVICE_FILE" <<EOF
[Unit]
Description=$APP_NAME Spring Boot App
After=network.target mysql.service

[Service]
User=$SUDO_USER
WorkingDirectory=$APP_DIR
ExecStart=/usr/bin/java -jar $APP_DIR/target/$JAR_NAME
SuccessExitStatus=143
Restart=always
RestartSec=10
Environment=SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/$DB_NAME
Environment=SPRING_DATASOURCE_USERNAME=$DB_USER
Environment=SPRING_DATASOURCE_PASSWORD=$DB_PASS
Environment=SERVER_PORT=$SPRING_PORT

[Install]
WantedBy=multi-user.target
EOF

systemctl daemon-reload
systemctl enable "$APP_NAME"
systemctl start "$APP_NAME"

# 7. Verificar
echo "[7/7] Verificando despliegue..."
sleep 5
if systemctl is-active --quiet "$APP_NAME"; then
    echo "========================================"
    echo "  Despliegue completado con EXITO!"
    echo "========================================"
    echo "App: http://$(curl -s ifconfig.me):$SPRING_PORT"
    echo "Estado: $(systemctl status $APP_NAME | grep Active)"
    echo ""
    echo "Comandos utiles:"
    echo "  sudo systemctl status $APP_NAME"
    echo "  sudo journalctl -u $APP_NAME -f"
    echo "  sudo systemctl stop $APP_NAME"
    echo "  sudo systemctl restart $APP_NAME"
else
    echo "ERROR: El servicio no inicio correctamente."
    echo "Revisa los logs: sudo journalctl -u $APP_NAME -f"
    systemctl status "$APP_NAME"
fi
