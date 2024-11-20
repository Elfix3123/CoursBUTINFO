from unidecode import unidecode
import pickle 

isLetter = lambda l : (len(l) == 1 and ord(l) > 65 and ord(l) < 90)

def computeLetters():
	dict = {}
	with open('bovary.txt', 'r') as file:
		for line in file:
			i = 0
			while i < len(line)-1:
				letter1, letter2 = unidecode(line[i]).capitalize(), unidecode(line[i+1]).capitalize()
				if isLetter(letter1) and isLetter(letter2):
					if letter1+letter2 not in dict.keys():
						dict[letter1+letter2] = 1
					else:
						dict[letter1+letter2] += 1
				i+=1

	return {k: v/5000 for k, v in sorted(dict.items(), key=lambda item: item[1], reverse=True)}


def saveDict(dict, filename):
	with open(filename, 'wb') as f:
		pickle.dump(dict, f)

letters = computeLetters()
print(letters)
saveDict(letters, 'bovary.pkl')