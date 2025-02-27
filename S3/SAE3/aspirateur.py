import psycopg2
import requests
import csv
import re
import os 
from urllib.parse import quote, unquote

with open(os.path.dirname(os.path.realpath(__file__)) + "/stopwords.txt", "r") as f:
	stopwords = f.read().split("\n")

connection = psycopg2.connect(database="mrmv", user="mrmv", password="MrmV2024@&*plight", host="morgannas.myds.me", port=5432)
cursor = connection.cursor()
cursor.execute("SELECT nom_village, departement, id_village, coordonnees, description, place_id, image_url, histoire, wikipedia_url, score, population FROM spr ORDER BY id_village;")
record = cursor.fetchall()

def accentify(regex):
	regex = re.sub(r" |-|_", r"[ -_]", regex)
	regex = re.sub(r"a|à|â|ä|A|À|Â|Ä", r"[aàâäAÀÂÄ]", regex)
	regex = re.sub(r"e|é|è|ê|ë|E|É|È|Ê|Ë", r"[eéèêëEÉÈÊË]", regex)
	regex = re.sub(r"i|î|ï|I|Î|Ï", r"[iîïIÎÏ]", regex)
	regex = re.sub(r"o|ô|ö|O|Ô|Ö", r"[oôöOÔÖ]", regex)
	regex = re.sub(r"u|ù|û|ü|U|Ù|Û|Ü", r"[uùûüUÙÛÜ]", regex)
	regex = re.sub(r"y|ÿ|Y|Ÿ", r"[yÿYŸ]", regex)
	regex = re.sub(r"c|ç|C|Ç", r"[cçCÇ]", regex)
	return regex

def villagize(nom, stopwords):
	nom = nom.title()

	for word in stopwords:
		nom = re.sub(r'\b' + re.escape(word).title() + r'\b', word.lower(), nom)
	
	nom = nom[0].upper() + nom[1:]

	return nom

def findWikiPage(commune, departement):
	"""
	Renvoie le nom de la page Wikipedia de la commune du département passés en paramètres
	"""
	basename, depname, communename = "", "", ""
	# basename est le nom trouvé avec une recherche du nom de la commune
	# depname est le nom trouvé avec une recherche du nom de la commune et du departement
	# communename est le nom trouvé avec une recherche du nom de la commune et du mot clef "commune"

	response = requests.get("https://fr.wikipedia.org/w/api.php", params={"action": "opensearch", "search": commune, "format": "json"})
	pages = []

	if response.status_code == 200:
		pages += response.json()[3]

	response = requests.get("https://fr.wikipedia.org/w/api.php", params={"action": "opensearch", "search": commune + " " + departement, "format": "json"})

	if response.status_code == 200:
		pages += response.json()[3]
	
	for page in pages:
		###
		if depname == "":
			regex = accentify(r"^.*?(" + commune.title() + r"_\(" + departement.title() + r"\))$")

			matchObject = re.search(regex, unquote(page), flags=re.I)
			if matchObject is not None:
				depname = unquote(matchObject.groups()[0])

		###
		if communename == "":
			regex = accentify(r"^.*?(" + commune.title() + r"_\(commune\))$")

			matchObject = re.search(regex, unquote(page), flags=re.I)
			if matchObject is not None:
				communename = unquote(matchObject.groups()[0])

		###
		if basename == "":
			regex = accentify(r"^.*?(" + commune.title() + r")$")

			matchObject = re.search(regex, unquote(page), flags=re.I)
			if matchObject is not None:
				basename = unquote(matchObject.groups()[0])

	return (depname if depname != "" else communename if communename != "" else basename if basename != "" else None)

def descriptionify(description):
	description = re.sub(r"\t", r"", description)
	while re.search(r"\n\n", description):
		description = re.sub(r"\n\n", r"\n", description)
	description = re.sub(r"===== (.*?) =====", r"### \1", description)
	description = re.sub(r"==== (.*?) ====", r"## \1", description)
	description = re.sub(r"=== (.*?) ===", r"# \1", description).strip()

	return description

for village in record:
	faireCoordonnees, faireDescription, fairePlacesId, faireImageUrl, faireHistoire, faireWikipediaUrl, faireScore = village[3] is None, village[4] is None, village[5] is None, village[6] is None, village[7] is None, village[8] is None, village[9] is None
	faireHistoire, faireDescription = True, True
	coordinates, imageurl, description, placesid, histoire, wikipediaUrl, score = None, None, None, None, None, None, None

	if faireCoordonnees or faireDescription or faireImageUrl or faireHistoire or faireWikipediaUrl or faireScore:
		commune, departement, idvillage, population = village[0], village[1], village[2], village[10]

		nomWikiPage = findWikiPage(commune, departement)

		if nomWikiPage is not None:
			wikipediaUrl = "https://fr.wikipedia.org/wiki/" + nomWikiPage

			try:
				response = requests.get("https://fr.wikipedia.org/w/api.php", params={"action": "query", "titles": nomWikiPage, "prop": "coordinates|extracts|pageimages|images", "format": "json", "explaintext": "true", "redirects": "", "piprop": "original", "imlimit": "500"})
				data = response.json()
				page = list(data["query"]["pages"].values())[0]

				if faireScore:
					score = len(page["extract"])
					score += len(page["images"]) * 100
					if population is not None:
						score = score / population
					else:
						score = score / 1000

				if faireCoordonnees:
					coordinates = page["coordinates"][0]["lat"], page["coordinates"][0]["lon"]

				if faireImageUrl:
					if "original" in page:
						imageurl = page["original"]["source"]

				if faireDescription:
					matchObject = re.search(r"^(.*?)\n", page["extract"])
					description = matchObject.group(1)
					description = descriptionify(description)
				
				if faireHistoire:
					matchObject = re.search(r"== Histoire ==\n([\S\s]*?)\n== ", page["extract"])	
					histoire = matchObject.group(1)
					histoire = descriptionify(histoire)	

			except Exception as e:
				print(e)

	if fairePlacesId:
		response = requests.post("https://places.googleapis.com/v1/places:searchText", params={"textQuery": commune + " " + departement}, headers={"X-Goog-Api-Key": "AIzaSyDgBaIHStNcv0dqJ05x3hb-08nd5b0YeEE", "Content-Type": "application/json", "X-Goog-FieldMask": "places.id"})
		data = response.json()
		placesid = data["places"][0]["id"]
	
	if coordinates is not None or description is not None or placesid is not None or imageurl is not None or histoire is not None or wikipediaUrl is not None or score is not None:
		query = "UPDATE spr SET nom_village = %s, "
		parameters = [villagize(commune, stopwords)]
		if coordinates is not None:
			query += "coordonnees = POINT(%s,%s), "
			parameters.append(coordinates[0])
			parameters.append(coordinates[1])
		if description is not None:
			query += "description = %s, "
			parameters.append(description)
		if placesid is not None:
			query += "place_id = %s, "
			parameters.append(placesid)
		if imageurl is not None:
			query += "image_url = %s, "
			parameters.append(imageurl)
		if histoire is not None:
			query += "histoire = %s, "
			parameters.append(histoire)
		if wikipediaUrl is not None:
			query += "wikipedia_url = %s, "
			parameters.append(wikipediaUrl)
		if score is not None:
			query += "score = %s, "
			parameters.append(score)
		query = query[:-2] + " WHERE id_village = %s;"
		parameters.append(idvillage)
		print("id_village = ", idvillage, ", commune", villagize(commune, stopwords), ", coord = ", coordinates, ", description = ", description is not None, ", placesid = ", placesid, ", imageurl = ", imageurl, ", histoire = ", histoire is not None, ", wikipediaUrl = ", wikipediaUrl, ", score = ", score)

		cursor.execute(query, parameters)
		connection.commit()