-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost    Database: gescol
-- ------------------------------------------------------
-- Server version	8.0.45-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acudientes`
--

DROP TABLE IF EXISTS `acudientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acudientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `numero_cedula` varchar(255) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK33gabgg7pxy3w3l41vedctlhh` (`numero_cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acudientes`
--

LOCK TABLES `acudientes` WRITE;
/*!40000 ALTER TABLE `acudientes` DISABLE KEYS */;
INSERT INTO `acudientes` VALUES (1,'Gomez Clavijo',NULL,NULL,'Cecilia ','91234234','310987234'),(2,'Vega',NULL,NULL,'Esperanza','60778405','3002104081'),(3,'Araya',NULL,NULL,'Joel','58061979','3004278755'),(4,'Garita',NULL,NULL,'Omar','40047550','3007264820'),(5,'Mendez',NULL,NULL,'Camila','73378470','3001125228'),(6,'Garita',NULL,NULL,'Kevin','19499144','3007296882'),(7,'Diaz',NULL,NULL,'Francisco','65307139','3006422016'),(8,'Morales',NULL,NULL,'Graciela','84683508','3004153526'),(9,'Campos',NULL,NULL,'Graciela','92575088','3002341711'),(10,'Soto',NULL,NULL,'Adriana','56718239','3008230220'),(11,'Rivera',NULL,NULL,'Antonella','26761269','3007454758'),(12,'Padilla',NULL,NULL,'Alejandra','69705711','3006799580'),(13,'Romero',NULL,NULL,'Felipe','91929610','3005178674'),(14,'Paredes',NULL,NULL,'Fernando','67506472','3006168835'),(15,'Paredes',NULL,NULL,'Isabella','41970132','3001957015'),(16,'Rivas',NULL,NULL,'Manuela','52829555','3005419110'),(17,'Gutierrez',NULL,NULL,'Lydia','34170461','3003382779'),(18,'Paredes',NULL,NULL,'Maria','20695323','3003249899'),(19,'Giraldo',NULL,NULL,'Esperanza','27612941','3005581931'),(20,'Diaz',NULL,NULL,'Fernanda','19791988','3002687945'),(21,'Sandoval',NULL,NULL,'Lucas','56754668','3009402930'),(22,'Castro',NULL,NULL,'Valeria','73933964','3001725510'),(23,'Rojas',NULL,NULL,'Sara','33864165','3005445652'),(24,'Cardona',NULL,NULL,'Beatriz','29963350','3007462483'),(25,'Ceballos',NULL,NULL,'Sara','48717964','3005772704'),(26,'Ceballos',NULL,NULL,'Alejandro','29882674','3006070487'),(27,'Pacheco',NULL,NULL,'Lucas','38606794','3002971568'),(28,'Solis',NULL,NULL,'Alejandra','72400501','3003584765'),(29,'Mora',NULL,NULL,'Dulce','59400266','3007172829'),(30,'Montes',NULL,NULL,'Raul','16606522','3005698547'),(31,'Reyes',NULL,NULL,'Mario','57482172','3003485721'),(32,'Martinez',NULL,NULL,'Javier','79206527','3005798737'),(33,'Reyes',NULL,NULL,'Gustavo','87896772','3001111412'),(34,'Martinez',NULL,NULL,'Edwin','19056638','3008324711'),(35,'Maldonado',NULL,NULL,'Benjamin','23490266','3009237933'),(36,'Carrillo',NULL,NULL,'Leticia','35156365','3003347170'),(37,'Infante',NULL,NULL,'Oscar','21890044','3001486890'),(38,'Londoño',NULL,NULL,'Felipe','61189257','3009516735'),(39,'Figueroa',NULL,NULL,'Gabriela','57998584','3003205268'),(40,'Ospina',NULL,NULL,'Maria','37883156','3004996158'),(41,'Chavez',NULL,NULL,'Francisco','38786039','3003912901'),(42,'Medina',NULL,NULL,'Antonella','63891458','3008281620'),(43,'Rodriguez',NULL,NULL,'Noelia','24268318','3008991056'),(44,'Ospina',NULL,NULL,'Tatiana','83434174','3002514021'),(45,'Ramos',NULL,NULL,'Raul','37272235','3002325105'),(46,'Morales',NULL,NULL,'Camila','56279197','3005675307'),(47,'Calderon',NULL,NULL,'Monica','12185809','3005702429'),(48,'Solis',NULL,NULL,'Ruth','86996081','3007665950'),(49,'Cano',NULL,NULL,'Lucas','72338345','3007970211'),(50,'Pena',NULL,NULL,'Leticia','61865369','3006997469'),(51,'Vega',NULL,NULL,'Andrea','28906605','3005778098'),(52,'Ortiz',NULL,NULL,'Ruth','24966375','3008355547'),(53,'Medina',NULL,NULL,'Pablo','14145501','3002775404'),(54,'Ramirez',NULL,NULL,'Samuel','46187617','3004241039'),(55,'Arias',NULL,NULL,'Hugo','15679497','3007115763'),(56,'Flores',NULL,NULL,'David','95865304','3001191432'),(57,'Ramirez',NULL,NULL,'Ivan','78778757','3005114507'),(58,'Araya',NULL,NULL,'William','25854959','3004029548'),(59,'Ruiz',NULL,NULL,'Dulce','22106794','3005074275'),(60,'Correa',NULL,NULL,'Hector','94663426','3008079510'),(61,'Ospina',NULL,NULL,'Gustavo','63977973','3003265212'),(62,'Barrios',NULL,NULL,'Benjamin','14950914','3002438573'),(63,'Montes',NULL,NULL,'Daniela','78298887','3007402947'),(64,'Molina',NULL,NULL,'Lydia','33088407','3004923031'),(65,'Chavez',NULL,NULL,'Mariana','78354760','3009274155'),(66,'Arias',NULL,NULL,'Patricia','23776739','3001559059'),(67,'Restrepo',NULL,NULL,'Luis','80780228','3008186249'),(68,'Escobar',NULL,NULL,'David','10534749','3006992992'),(69,'Miranda',NULL,NULL,'Patricia','44967817','3004027637'),(70,'Morales',NULL,NULL,'Hector','94071283','3004544062'),(71,'Medina',NULL,NULL,'Felipe','59685393','3001602812'),(72,'Barrios',NULL,NULL,'Daniel','42257317','3007758868'),(73,'Infante',NULL,NULL,'Ivan','55331746','3002818562'),(74,'Correa',NULL,NULL,'Beatriz','26980232','3002475400'),(75,'Campos',NULL,NULL,'Camila','95837714','3007823974'),(76,'Ospina',NULL,NULL,'Nelly','31551867','3005348977'),(77,'Valencia',NULL,NULL,'Manuela','60608458','3001611811'),(78,'Ospina',NULL,NULL,'Arturo','32347913','3003466855'),(79,'Acosta',NULL,NULL,'Claudia','16547758','3009072973'),(80,'Murillo',NULL,NULL,'Sara','54215317','3007276186'),(81,'Ceballos',NULL,NULL,'Cesar','18240818','3009997410'),(82,'Paredes',NULL,NULL,'William','38091257','3005704071'),(83,'Cruz',NULL,NULL,'Juan','69990855','3008434435'),(84,'Ruiz',NULL,NULL,'Aaron','45387893','3002875556'),(85,'Rivas',NULL,NULL,'Nelly','43221921','3008182573'),(86,'Avila',NULL,NULL,'Ruth','21696722','3004824995'),(87,'Araya',NULL,NULL,'Rafael','24136608','3003701641'),(88,'Chavez',NULL,NULL,'Jaime','44979491','3003676893'),(89,'Mora',NULL,NULL,'Joel','53058445','3004652030'),(90,'Orozco',NULL,NULL,'Valentina','83863885','3007455010'),(91,'Tovar',NULL,NULL,'Estela','97272275','3002362692'),(92,'Ortiz',NULL,NULL,'Claudia','48804410','3006957688'),(93,'Ceballos',NULL,NULL,'Leonardo','29093975','3008918494'),(94,'Garcia',NULL,NULL,'Hugo','61278639','3007129775'),(95,'Sandoval',NULL,NULL,'Noelia','62289891','3006224357'),(96,'Pena',NULL,NULL,'Carlos','25601624','3005926219'),(97,'Guerrero',NULL,NULL,'Arturo','14589015','3002770366'),(98,'Sanchez',NULL,NULL,'Pablo','72634382','3001328207'),(99,'Barrantes',NULL,NULL,'Luis','34182747','3009341280'),(100,'Beltran',NULL,NULL,'Tatiana','81841160','3009358196'),(101,'Solano',NULL,NULL,'Samuel','52967241','3005598012');
/*!40000 ALTER TABLE `acudientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_acudiente`
--

DROP TABLE IF EXISTS `alumno_acudiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno_acudiente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `parentesco` varchar(255) DEFAULT NULL,
  `acudiente_id` bigint NOT NULL,
  `alumno_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgs8g8bbuwkigrrnotjb05hxr7` (`acudiente_id`),
  KEY `FK4err42o2it4capusw5d1k1gk9` (`alumno_id`),
  CONSTRAINT `FK4err42o2it4capusw5d1k1gk9` FOREIGN KEY (`alumno_id`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FKgs8g8bbuwkigrrnotjb05hxr7` FOREIGN KEY (`acudiente_id`) REFERENCES `acudientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_acudiente`
--

LOCK TABLES `alumno_acudiente` WRITE;
/*!40000 ALTER TABLE `alumno_acudiente` DISABLE KEYS */;
INSERT INTO `alumno_acudiente` VALUES (1,'Madre',1,1),(2,'Madre',2,2),(3,'Madre',3,3),(4,'Padre',4,4),(5,'Tia',5,5),(6,'Tutor',6,6),(7,'Tutor',7,7),(8,'Hermano',8,8),(9,'Abuelo',9,9),(10,'Tio',10,10),(11,'Hermano',11,11),(12,'Abuelo',12,12),(13,'Tia',13,13),(14,'Tia',14,14),(15,'Abuelo',15,15),(16,'Tio',16,16),(17,'Madre',17,17),(18,'Abuela',18,18),(19,'Abuela',19,19),(20,'Tia',20,20),(21,'Tutor',21,21),(22,'Padre',22,22),(23,'Abuela',23,23),(24,'Hermana',24,24),(25,'Abuela',25,25),(26,'Padre',26,26),(27,'Tia',27,27),(28,'Hermano',28,28),(29,'Tutor',29,29),(30,'Madre',30,30),(31,'Abuelo',31,31),(32,'Abuelo',32,32),(33,'Padre',33,33),(34,'Abuelo',34,34),(35,'Abuela',35,35),(36,'Padre',36,36),(37,'Abuelo',37,37),(38,'Tio',38,38),(39,'Abuelo',39,39),(40,'Padre',40,40),(41,'Tio',41,41),(42,'Tutor',42,42),(43,'Hermana',43,43),(44,'Tutor',44,44),(45,'Hermana',45,45),(46,'Tio',46,46),(47,'Hermana',47,47),(48,'Tutor',48,48),(49,'Abuela',49,49),(50,'Tia',50,50),(51,'Abuela',51,51),(52,'Madre',52,52),(53,'Madre',53,53),(54,'Abuelo',54,54),(55,'Abuelo',55,55),(56,'Tia',56,56),(57,'Abuela',57,57),(58,'Abuela',58,58),(59,'Hermana',59,59),(60,'Tia',60,60),(61,'Hermano',61,61),(62,'Padre',62,62),(63,'Abuelo',63,63),(64,'Tio',64,64),(65,'Hermana',65,65),(66,'Hermano',66,66),(67,'Madre',67,67),(68,'Tutor',68,68),(69,'Abuelo',69,69),(70,'Padre',70,70),(71,'Hermano',71,71),(72,'Madre',72,72),(73,'Hermano',73,73),(74,'Hermana',74,74),(75,'Hermano',75,75),(76,'Tutor',76,76),(77,'Tia',77,77),(78,'Abuelo',78,78),(79,'Hermano',79,79),(80,'Abuela',80,80),(81,'Abuela',81,81),(82,'Tio',82,82),(83,'Tutor',83,83),(84,'Hermana',84,84),(85,'Abuela',85,85),(86,'Abuelo',86,86),(87,'Tutor',87,87),(88,'Tia',88,88),(89,'Madre',89,89),(90,'Tio',90,90),(91,'Abuelo',91,91),(92,'Hermana',92,92),(93,'Abuela',93,93),(94,'Tio',94,94),(95,'Abuelo',95,95),(96,'Madre',96,96),(97,'Tio',97,97),(98,'Abuelo',98,98),(99,'Hermana',99,99),(100,'Tio',100,100),(101,'Abuelo',101,101);
/*!40000 ALTER TABLE `alumno_acudiente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `codigo_estudiantil` varchar(255) NOT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `ingreso_con_acudiente` bit(1) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `salida_con_acudiente` bit(1) DEFAULT NULL,
  `grado_id` bigint DEFAULT NULL,
  `ruta_ingreso_id` bigint DEFAULT NULL,
  `ruta_salida_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKd1tdgmj2pxddqg562qdm6bh4j` (`codigo_estudiantil`),
  KEY `FKq4e8tyj5w5w6g19j9ggfqy0uq` (`grado_id`),
  KEY `FKc9r8vtc5dw4ofh347fnjr3gkc` (`ruta_ingreso_id`),
  KEY `FKeyljjkoo40gkao89tjxjdq6f5` (`ruta_salida_id`),
  CONSTRAINT `FKc9r8vtc5dw4ofh347fnjr3gkc` FOREIGN KEY (`ruta_ingreso_id`) REFERENCES `rutas` (`id`),
  CONSTRAINT `FKeyljjkoo40gkao89tjxjdq6f5` FOREIGN KEY (`ruta_salida_id`) REFERENCES `rutas` (`id`),
  CONSTRAINT `FKq4e8tyj5w5w6g19j9ggfqy0uq` FOREIGN KEY (`grado_id`) REFERENCES `tb_grado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Ortiz Giraldo','EST001',NULL,_binary '\0','Andrea ',_binary '\0',4,1,2),(2,'Galvis','EST002',NULL,_binary '','Esperanza',_binary '\0',10,NULL,4),(3,'Diaz','EST003',NULL,_binary '','Jorge',_binary '',18,NULL,NULL),(4,'Molina','EST004',NULL,_binary '','Rafael',_binary '',7,NULL,NULL),(5,'Restrepo','EST005',NULL,_binary '','Valeria',_binary '\0',5,NULL,3),(6,'Alzate','EST006',NULL,_binary '\0','Cesar',_binary '\0',8,3,4),(7,'Ramirez','EST007',NULL,_binary '\0','Beatriz',_binary '',10,1,NULL),(8,'Orozco','EST008',NULL,_binary '\0','Hector',_binary '',4,3,NULL),(9,'Sandoval','EST009',NULL,_binary '','Lydia',_binary '',20,NULL,NULL),(10,'Piedrahita','EST010',NULL,_binary '','Javier',_binary '',11,NULL,NULL),(11,'Ramirez','EST011',NULL,_binary '\0','Sofia',_binary '',20,4,NULL),(12,'Garita','EST012',NULL,_binary '\0','Martha',_binary '\0',19,4,3),(13,'Garita','EST013',NULL,_binary '','Lorena',_binary '',11,NULL,NULL),(14,'Delgado','EST014',NULL,_binary '','Sebastian',_binary '',18,NULL,NULL),(15,'Escobar','EST015',NULL,_binary '\0','Oscar',_binary '\0',18,3,4),(16,'Arias','EST016',NULL,_binary '','Ramon',_binary '\0',12,NULL,1),(17,'Sandoval','EST017',NULL,_binary '\0','Juan',_binary '\0',12,2,4),(18,'Barrios','EST018',NULL,_binary '\0','Alejandra',_binary '',5,2,NULL),(19,'Vargas','EST019',NULL,_binary '\0','Jaime',_binary '\0',5,1,2),(20,'Gonzalez','EST020',NULL,_binary '','Nelly',_binary '',6,NULL,NULL),(21,'Rondon','EST021',NULL,_binary '\0','Ramon',_binary '\0',19,4,2),(22,'Garcia','EST022',NULL,_binary '\0','Beatriz',_binary '',7,3,NULL),(23,'Ruiz','EST023',NULL,_binary '\0','Sara',_binary '\0',20,1,1),(24,'Torres','EST024',NULL,_binary '\0','Pablo',_binary '',18,1,NULL),(25,'Diaz','EST025',NULL,_binary '\0','Nicolle',_binary '',12,2,NULL),(26,'Torres','EST026',NULL,_binary '','Noelia',_binary '\0',20,NULL,2),(27,'Echeverri','EST027',NULL,_binary '','Javier',_binary '\0',9,NULL,3),(28,'Peralta','EST028',NULL,_binary '','Fernando',_binary '',4,NULL,NULL),(29,'Zamora','EST029',NULL,_binary '','Daniel',_binary '\0',9,NULL,1),(30,'Medina','EST030',NULL,_binary '','Lucas',_binary '\0',17,NULL,3),(31,'Mendez','EST031',NULL,_binary '\0','Ricardo',_binary '\0',16,4,3),(32,'Ramos','EST032',NULL,_binary '\0','Ximena',_binary '',4,1,NULL),(33,'Gutierrez','EST033',NULL,_binary '\0','Samuel',_binary '\0',8,3,3),(34,'Gonzalez','EST034',NULL,_binary '\0','Aaron',_binary '\0',20,1,4),(35,'Gonzalez','EST035',NULL,_binary '','Daniela',_binary '\0',11,NULL,1),(36,'Cano','EST036',NULL,_binary '','David',_binary '\0',9,NULL,4),(37,'Hernandez','EST037',NULL,_binary '\0','David',_binary '',6,3,NULL),(38,'Restrepo','EST038',NULL,_binary '','William',_binary '',14,NULL,NULL),(39,'Mora','EST039',NULL,_binary '\0','Lydia',_binary '',17,3,NULL),(40,'Flores','EST040',NULL,_binary '\0','Daniela',_binary '',19,4,NULL),(41,'Miranda','EST041',NULL,_binary '\0','Leonardo',_binary '',20,1,NULL),(42,'Jimenez','EST042',NULL,_binary '\0','Leticia',_binary '\0',14,4,2),(43,'Rondon','EST043',NULL,_binary '\0','Ivan',_binary '',16,4,NULL),(44,'Torres','EST044',NULL,_binary '\0','Omar',_binary '',12,2,NULL),(45,'Leon','EST045',NULL,_binary '','Carolina',_binary '',16,NULL,NULL),(46,'Tovar','EST046',NULL,_binary '','William',_binary '\0',10,NULL,1),(47,'Rojas','EST047',NULL,_binary '\0','Estela',_binary '',17,2,NULL),(48,'Zamora','EST048',NULL,_binary '\0','Rogelio',_binary '\0',12,3,3),(49,'Cardenas','EST049',NULL,_binary '','Samuel',_binary '',5,NULL,NULL),(50,'Mendez','EST050',NULL,_binary '','Claudia',_binary '\0',8,NULL,2),(51,'Ospina','EST051',NULL,_binary '\0','Yolanda',_binary '',17,2,NULL),(52,'Calderon','EST052',NULL,_binary '','David',_binary '\0',15,NULL,1),(53,'Garcia','EST053',NULL,_binary '','Salome',_binary '',5,NULL,NULL),(54,'Peralta','EST054',NULL,_binary '\0','Valeria',_binary '',7,2,NULL),(55,'Londoño','EST055',NULL,_binary '','Sara',_binary '\0',8,NULL,2),(56,'Escobar','EST056',NULL,_binary '','Martha',_binary '\0',17,NULL,3),(57,'Ramirez','EST057',NULL,_binary '\0','Ramon',_binary '\0',19,2,3),(58,'Garcia','EST058',NULL,_binary '','Isabella',_binary '\0',18,NULL,3),(59,'Mora','EST059',NULL,_binary '\0','Santiago',_binary '',14,2,NULL),(60,'Morales','EST060',NULL,_binary '','Manuela',_binary '',18,NULL,NULL),(61,'Reyes','EST061',NULL,_binary '','Samuel',_binary '\0',16,NULL,3),(62,'Barrantes','EST062',NULL,_binary '\0','Ximena',_binary '',19,4,NULL),(63,'Ruiz','EST063',NULL,_binary '','Ana',_binary '\0',14,NULL,3),(64,'Arango','EST064',NULL,_binary '','Juan',_binary '',8,NULL,NULL),(65,'Martinez','EST065',NULL,_binary '','Andres',_binary '',5,NULL,NULL),(66,'Vargas','EST066',NULL,_binary '','Mateo',_binary '',19,NULL,NULL),(67,'Delgado','EST067',NULL,_binary '','Alejandra',_binary '\0',4,NULL,1),(68,'Marin','EST068',NULL,_binary '','Diego',_binary '\0',18,NULL,3),(69,'Restrepo','EST069',NULL,_binary '','Aaron',_binary '\0',12,NULL,2),(70,'Arias','EST070',NULL,_binary '','Francisco',_binary '\0',16,NULL,2),(71,'Bermudez','EST071',NULL,_binary '\0','Francisco',_binary '\0',12,4,3),(72,'Diaz','EST072',NULL,_binary '\0','Rocio',_binary '\0',7,4,3),(73,'Romero','EST073',NULL,_binary '\0','Sofia',_binary '\0',8,3,4),(74,'Lopez','EST074',NULL,_binary '\0','Oscar',_binary '\0',9,4,4),(75,'Piedrahita','EST075',NULL,_binary '\0','Juan',_binary '\0',20,3,1),(76,'Barrantes','EST076',NULL,_binary '\0','Mateo',_binary '',19,2,NULL),(77,'Castillo','EST077',NULL,_binary '\0','Luis',_binary '',11,4,NULL),(78,'Solis','EST078',NULL,_binary '\0','Karina',_binary '\0',8,4,3),(79,'Mora','EST079',NULL,_binary '','Mariana',_binary '',8,NULL,NULL),(80,'Lopez','EST080',NULL,_binary '\0','Sebastian',_binary '\0',8,3,1),(81,'Moreno','EST081',NULL,_binary '\0','Patricia',_binary '',20,3,NULL),(82,'Ramos','EST082',NULL,_binary '','Gloria',_binary '\0',4,NULL,4),(83,'Alvarez','EST083',NULL,_binary '','Beatriz',_binary '',4,NULL,NULL),(84,'Campos','EST084',NULL,_binary '\0','Jaime',_binary '',18,3,NULL),(85,'Valencia','EST085',NULL,_binary '','Sebastian',_binary '',14,NULL,NULL),(86,'Sanchez','EST086',NULL,_binary '','Lydia',_binary '',9,NULL,NULL),(87,'Ortiz','EST087',NULL,_binary '','Rafael',_binary '',16,NULL,NULL),(88,'Calderon','EST088',NULL,_binary '\0','Yolanda',_binary '',9,3,NULL),(89,'Martinez','EST089',NULL,_binary '','Ivan',_binary '\0',9,NULL,3),(90,'Miranda','EST090',NULL,_binary '','Raul',_binary '',8,NULL,NULL),(91,'Beltran','EST091',NULL,_binary '\0','Andrea',_binary '',16,4,NULL),(92,'Morales','EST092',NULL,_binary '\0','Gabriel',_binary '',5,2,NULL),(93,'Correa','EST093',NULL,_binary '','Hugo',_binary '\0',15,NULL,3),(94,'Jimenez','EST094',NULL,_binary '','Sara',_binary '\0',6,NULL,3),(95,'Miranda','EST095',NULL,_binary '\0','Lorena',_binary '\0',13,3,4),(96,'Avila','EST096',NULL,_binary '\0','Natalia',_binary '\0',18,4,3),(97,'Londoño','EST097',NULL,_binary '','Joel',_binary '',18,NULL,NULL),(98,'Cardona','EST098',NULL,_binary '','Manuela',_binary '\0',5,NULL,1),(99,'Escobar','EST099',NULL,_binary '','Esperanza',_binary '\0',16,NULL,3),(100,'Barrantes','EST100',NULL,_binary '','Jose',_binary '\0',7,NULL,2),(101,'Herrera','EST101',NULL,_binary '\0','Daniel',_binary '\0',18,4,3);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estado` enum('ASISTIO','AUSENTE','TARDE') DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `motivo_salida` text,
  `observaciones` text,
  `salida_anticipada` bit(1) DEFAULT NULL,
  `alumno_id` bigint NOT NULL,
  `coordinador_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl7mt54r86x0k53qw4893i114f` (`alumno_id`),
  KEY `FKmwklcd159tbjajl7j40aa3tsm` (`coordinador_id`),
  CONSTRAINT `FKl7mt54r86x0k53qw4893i114f` FOREIGN KEY (`alumno_id`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FKmwklcd159tbjajl7j40aa3tsm` FOREIGN KEY (`coordinador_id`) REFERENCES `titulares` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
INSERT INTO `asistencia` VALUES (1,'ASISTIO','2026-05-30','2026-05-30 06:26:11.518572',NULL,NULL,NULL,_binary '\0',1,NULL),(2,'ASISTIO','2026-05-30','2026-05-30 06:26:11.675960',NULL,NULL,NULL,_binary '\0',8,NULL),(3,'ASISTIO','2026-05-30','2026-05-30 06:26:11.706941',NULL,NULL,NULL,_binary '\0',28,NULL),(4,'ASISTIO','2026-05-30','2026-05-30 06:26:11.744191',NULL,NULL,NULL,_binary '\0',32,NULL),(5,'AUSENTE','2026-05-30','2026-05-30 06:26:11.779845',NULL,NULL,NULL,_binary '\0',67,NULL),(6,'AUSENTE','2026-05-30','2026-05-30 06:26:11.809196',NULL,NULL,NULL,_binary '\0',82,NULL),(7,'ASISTIO','2026-05-30','2026-05-30 06:26:11.839027',NULL,NULL,NULL,_binary '\0',83,NULL),(8,'ASISTIO','2026-05-30','2026-05-30 06:28:25.855604',NULL,NULL,NULL,_binary '\0',2,NULL),(9,'AUSENTE','2026-05-30','2026-05-30 06:28:25.892420',NULL,NULL,NULL,_binary '\0',7,NULL),(10,'ASISTIO','2026-05-30','2026-05-30 06:28:26.270421',NULL,NULL,NULL,_binary '\0',46,NULL),(11,'AUSENTE','2026-05-30','2026-05-30 06:29:04.403339',NULL,NULL,NULL,_binary '\0',16,NULL),(12,'ASISTIO','2026-05-30','2026-05-30 06:29:04.440925',NULL,NULL,NULL,_binary '\0',17,NULL),(13,'ASISTIO','2026-05-30','2026-05-30 06:29:04.472877',NULL,NULL,NULL,_binary '\0',25,NULL),(14,'AUSENTE','2026-05-30','2026-05-30 06:29:04.502782',NULL,NULL,NULL,_binary '\0',44,NULL),(15,'ASISTIO','2026-05-30','2026-05-30 06:29:04.531449',NULL,NULL,NULL,_binary '\0',48,NULL),(16,'ASISTIO','2026-05-30','2026-05-30 06:29:04.563051',NULL,NULL,NULL,_binary '\0',69,NULL),(17,'AUSENTE','2026-05-30','2026-05-30 06:29:04.591318',NULL,NULL,NULL,_binary '\0',71,NULL),(18,'ASISTIO','2026-05-30','2026-05-30 06:30:03.615695','09:29:00','Enfermedad \nTos ',NULL,_binary '',54,1),(19,'ASISTIO','2026-05-30','2026-05-30 06:31:09.138861',NULL,NULL,NULL,_binary '\0',4,NULL),(20,'ASISTIO','2026-05-30','2026-05-30 06:31:09.174874',NULL,NULL,NULL,_binary '\0',22,NULL),(21,'ASISTIO','2026-05-30','2026-05-30 06:31:09.234947',NULL,NULL,NULL,_binary '\0',72,NULL),(22,'ASISTIO','2026-05-30','2026-05-30 06:31:09.268179',NULL,NULL,NULL,_binary '\0',100,NULL);
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control_ruta`
--

DROP TABLE IF EXISTS `control_ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control_ruta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `llego` bit(1) DEFAULT NULL,
  `tipo` varchar(255) NOT NULL,
  `alumno_id` bigint NOT NULL,
  `ruta_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtq19c69kgqasc006c222pyt9c` (`alumno_id`),
  KEY `FKcht0jlrosrgm7w29a8vky2f0v` (`ruta_id`),
  CONSTRAINT `FKcht0jlrosrgm7w29a8vky2f0v` FOREIGN KEY (`ruta_id`) REFERENCES `rutas` (`id`),
  CONSTRAINT `FKtq19c69kgqasc006c222pyt9c` FOREIGN KEY (`alumno_id`) REFERENCES `alumnos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_ruta`
--

LOCK TABLES `control_ruta` WRITE;
/*!40000 ALTER TABLE `control_ruta` DISABLE KEYS */;
INSERT INTO `control_ruta` VALUES (1,'2026-05-30','2026-05-30 06:20:30.925679','06:00:00',_binary '','INGRESO',11,4),(2,'2026-05-30','2026-05-30 06:20:30.943411','06:00:00',_binary '','INGRESO',12,4),(3,'2026-05-30','2026-05-30 06:20:30.960196','06:00:00',_binary '\0','INGRESO',21,4),(4,'2026-05-30','2026-05-30 06:20:30.974960','06:00:00',_binary '','INGRESO',31,4),(5,'2026-05-30','2026-05-30 06:20:30.992006','06:00:00',_binary '','INGRESO',40,4),(6,'2026-05-30','2026-05-30 06:20:31.007394','06:00:00',_binary '','INGRESO',42,4),(7,'2026-05-30','2026-05-30 06:20:31.023167','06:00:00',_binary '','INGRESO',43,4),(8,'2026-05-30','2026-05-30 06:20:31.039634','06:00:00',_binary '','INGRESO',62,4),(9,'2026-05-30','2026-05-30 06:20:31.053164','06:00:00',_binary '','INGRESO',71,4),(10,'2026-05-30','2026-05-30 06:20:31.072141','06:00:00',_binary '','INGRESO',72,4),(11,'2026-05-30','2026-05-30 06:20:31.088155','06:00:00',_binary '\0','INGRESO',74,4),(12,'2026-05-30','2026-05-30 06:20:31.103597','06:00:00',_binary '','INGRESO',77,4),(13,'2026-05-30','2026-05-30 06:20:31.119746','06:00:00',_binary '','INGRESO',78,4),(14,'2026-05-30','2026-05-30 06:20:31.137690','06:00:00',_binary '','INGRESO',91,4),(15,'2026-05-30','2026-05-30 06:20:31.153212','06:00:00',_binary '\0','INGRESO',96,4),(16,'2026-05-30','2026-05-30 06:20:31.169597','06:00:00',_binary '','INGRESO',101,4),(17,'2026-05-30','2026-05-30 06:21:00.721970','06:10:00',_binary '','INGRESO',6,3),(18,'2026-05-30','2026-05-30 06:21:00.759236','06:10:00',_binary '','INGRESO',8,3),(19,'2026-05-30','2026-05-30 06:21:00.780430','06:10:00',_binary '\0','INGRESO',15,3),(20,'2026-05-30','2026-05-30 06:21:00.797807','06:10:00',_binary '','INGRESO',22,3),(21,'2026-05-30','2026-05-30 06:21:00.814920','06:10:00',_binary '','INGRESO',33,3),(22,'2026-05-30','2026-05-30 06:21:00.829836','06:10:00',_binary '\0','INGRESO',37,3),(23,'2026-05-30','2026-05-30 06:21:00.842881','06:10:00',_binary '','INGRESO',39,3),(24,'2026-05-30','2026-05-30 06:21:00.856796','06:10:00',_binary '','INGRESO',48,3),(25,'2026-05-30','2026-05-30 06:21:00.871866','06:10:00',_binary '','INGRESO',73,3),(26,'2026-05-30','2026-05-30 06:21:00.885849','06:10:00',_binary '\0','INGRESO',75,3),(27,'2026-05-30','2026-05-30 06:21:00.901233','06:10:00',_binary '','INGRESO',80,3),(28,'2026-05-30','2026-05-30 06:21:00.916871','06:10:00',_binary '','INGRESO',81,3),(29,'2026-05-30','2026-05-30 06:21:00.933570','06:10:00',_binary '\0','INGRESO',84,3),(30,'2026-05-30','2026-05-30 06:21:00.948502','06:10:00',_binary '','INGRESO',88,3),(31,'2026-05-30','2026-05-30 06:21:00.969178','06:10:00',_binary '','INGRESO',95,3),(32,'2026-05-30','2026-05-30 06:22:21.078300','06:21:00',_binary '','INGRESO',17,2),(33,'2026-05-30','2026-05-30 06:22:21.092161','06:21:00',_binary '','INGRESO',18,2),(34,'2026-05-30','2026-05-30 06:22:21.104878','06:21:00',_binary '','INGRESO',25,2),(35,'2026-05-30','2026-05-30 06:22:21.117824','06:21:00',_binary '\0','INGRESO',44,2),(36,'2026-05-30','2026-05-30 06:22:21.129406','06:21:00',_binary '','INGRESO',47,2),(37,'2026-05-30','2026-05-30 06:22:21.146732','06:21:00',_binary '','INGRESO',51,2),(38,'2026-05-30','2026-05-30 06:22:21.161657','06:21:00',_binary '','INGRESO',54,2),(39,'2026-05-30','2026-05-30 06:22:21.173156','06:21:00',_binary '','INGRESO',57,2),(40,'2026-05-30','2026-05-30 06:22:21.184886','06:21:00',_binary '\0','INGRESO',59,2),(41,'2026-05-30','2026-05-30 06:22:21.199097','06:21:00',_binary '','INGRESO',76,2),(42,'2026-05-30','2026-05-30 06:22:21.215519','06:21:00',_binary '','INGRESO',92,2),(43,'2026-05-30','2026-05-30 06:22:46.855029','05:22:00',_binary '','INGRESO',1,1),(44,'2026-05-30','2026-05-30 06:22:46.869363','05:22:00',_binary '','INGRESO',7,1),(45,'2026-05-30','2026-05-30 06:22:46.882484','05:22:00',_binary '\0','INGRESO',19,1),(46,'2026-05-30','2026-05-30 06:22:46.896299','05:22:00',_binary '','INGRESO',23,1),(47,'2026-05-30','2026-05-30 06:22:46.911366','05:22:00',_binary '','INGRESO',24,1),(48,'2026-05-30','2026-05-30 06:22:46.923276','05:22:00',_binary '\0','INGRESO',32,1),(49,'2026-05-30','2026-05-30 06:22:46.939577','05:22:00',_binary '','INGRESO',34,1),(50,'2026-05-30','2026-05-30 06:22:46.951718','05:22:00',_binary '','INGRESO',41,1),(51,'2026-05-30','2026-05-30 06:30:03.671709',NULL,_binary '\0','ENTREGA',54,2);
/*!40000 ALTER TABLE `control_ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `nombre_conductor` varchar(255) NOT NULL,
  `nombre_monitor` varchar(255) DEFAULT NULL,
  `numero_ruta` varchar(255) NOT NULL,
  `placa_vehiculo` varchar(255) NOT NULL,
  `telefono_conductor` varchar(255) DEFAULT NULL,
  `telefono_monitor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKd7ewu3n1kie5c6thlfm6hrw4j` (`numero_ruta`),
  UNIQUE KEY `UKd09w9rkybgvn8ahnbwf5ot7jk` (`placa_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,NULL,'Carlos Gaviria','Luisa Fernadez','1','asd123','321234345','234321234'),(2,NULL,'Ana Gutierrez Lozada','Leydi Niño','2','qwe456','315423445','316547234'),(3,NULL,'Wliam Galindo','Yeny Perez','3','cvb456','313345876','315432345'),(4,NULL,'Carlos Fuentes','Sandra Jerez','4','yui345','3213245230','3425345567');
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_grado`
--

DROP TABLE IF EXISTS `tb_grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_grado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcdwsnwbf892rjgc40jap35r2n` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_grado`
--

LOCK TABLES `tb_grado` WRITE;
/*!40000 ALTER TABLE `tb_grado` DISABLE KEYS */;
INSERT INTO `tb_grado` VALUES (1,NULL,'parvulos'),(2,NULL,'Jardín'),(3,NULL,'Transición'),(4,NULL,'101'),(5,NULL,'102'),(6,NULL,'103'),(7,NULL,'104'),(8,NULL,'201'),(9,NULL,'202'),(10,NULL,'203'),(11,NULL,'204'),(12,NULL,'301'),(13,NULL,'302'),(14,NULL,'303'),(15,NULL,'401'),(16,NULL,'402'),(17,NULL,'403'),(18,NULL,'501'),(19,NULL,'502'),(20,NULL,'503');
/*!40000 ALTER TABLE `tb_grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulares`
--

DROP TABLE IF EXISTS `titulares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `titulares` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `numero_cedula` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK48kpaqecdbc6lj0rtjd6wbmes` (`numero_cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulares`
--

LOCK TABLES `titulares` WRITE;
/*!40000 ALTER TABLE `titulares` DISABLE KEYS */;
INSERT INTO `titulares` VALUES (1,'Gomez Nigrinis','Academica',NULL,'Humberto ','1098123123','3123','COORDINADOR');
/*!40000 ALTER TABLE `titulares` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-30  6:38:04
