import qrcode, os

codes = [f"EST{str(i).zfill(3)}" for i in range(1, 21)]

for code in codes:
    img = qrcode.make(code)
    img.save(f"{code}.png")
    print(f"Generado: {code}.png")

html = """<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Codigos QR - ASISTECIA</title>
<style>
body { font-family: Arial; display: flex; flex-wrap: wrap; gap: 10px; padding: 20px; }
.card { border: 1px solid #ccc; border-radius: 8px; padding: 15px; text-align: center; width: 180px; }
.card img { width: 150px; height: 150px; }
.card p { margin: 8px 0 0; font-weight: bold; font-size: 16px; }
</style></head><body>
"""
for code in codes:
    html += f'<div class="card"><img src="{code}.png" alt="{code}"><p>{code}</p></div>\n'
html += "</body></html>"

with open("index.html", "w", encoding="utf-8") as f:
    f.write(html)

print(f"\nTotal: {len(codes)} QR generados")
print("Abrir index.html para verlos")
