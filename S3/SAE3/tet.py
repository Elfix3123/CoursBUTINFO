import re
import psycopg2

connection = psycopg2.connect(database="mrmv", user="mrmv", password="MrmV2024@&*plight", host="morgannas.myds.me", port=5432)
cursor = connection.cursor()
cursor.execute("SELECT id_village, description, histoire FROM spr WHERE id_village = 70 ORDER BY id_village;")
record = cursor.fetchall()
print(record[0][2])

with open("bite.txt", "w") as f:
	f.write(record[0][2])