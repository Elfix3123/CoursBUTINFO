import statistics as st
import random as rnd
import pickle 

isLetter = lambda l : (len(l) == 1 and ord(l) >= 65 and ord(l) <= 90)

LETTERS_FREQUENCIES = {
	"E": 17.76,
	"S": 8.23,
	"A": 7.68,
	"N": 7.61,
	"T": 7.30,
	"I": 7.23,
	"R": 6.81,
	"U": 6.05,
	"L": 5.89,
	"O": 5.34,
	"D": 3.60,
	"C": 3.32,
	"P": 3.24,
	"M": 2.72,
	"Q": 1.34,
	"V": 1.27,
	"G": 1.10,
	"F": 1.06,
	"B": 0.80,
	"H": 0.64,
	"X": 0.54,
	"Y": 0.21,
	"J": 0.19,
	"Z": 0.07,
	"K": 0.01,
	"W": 0.00
}
for key in LETTERS_FREQUENCIES.keys():
	LETTERS_FREQUENCIES[key] = LETTERS_FREQUENCIES[key] / 17.76

with open('bovary.pkl', 'rb') as f:
    PAIRS_FREQUENCIES = pickle.load(f)

MAX_ITERATIONS = 2**10

def chiffrerPermutations(msg: str,  key: dict) -> str:
	keysize = len( key)
	result = ""
	msgsize = (len(msg)//keysize+1)*keysize

	while len(msg) < msgsize:
		msg+=" "
	
	i = 0
	while i < msgsize:
		index =  key[i%keysize+1] + (i//keysize)*keysize - 1
		if index > len(msg) - 1:
			result += " "
		else:
			result += msg[index]
		i+=1
	return result

def chiffrerCesar(msg: str,  key: int) -> str:
	result = ""
	for letter in msg:
		result += " " if ord(letter) < 65 or ord(letter) > 90 else chr((ord(letter) - 65 +  key) % 26 + 65)
	return result

def chiffrerMono(msg: str,  key: dict) -> str:
	result = ""
	for letter in msg:
		result += str(key[letter]) if letter in key.keys() else letter
	return result

def chiffrerVigenere(msg: str,  key: str) -> str:
	result = ""
	i = 0
	for letter in msg:
		if isLetter(letter):
			result += chr((ord(letter)-65+ord(key[i])-65)%26+65)
			i = (i+1)%len(key)
		else:
			result += letter
	return result

def dechiffrerVigenere(msg: str,  key: str) -> str:
	newkey = ""
	for letter in key:
		newkey += chr((26-(ord(letter)-65))%26+65)
	return chiffrerVigenere(msg, newkey)

def computeLetterFrequency(msg: str) -> dict:
	i = 0
	computedLetterFrequency = {}
	while i < len(msg):
		if isLetter(msg[i]):
			if msg[i] not in computedLetterFrequency.keys():
				computedLetterFrequency[msg[i]] = 1
			else:
				computedLetterFrequency[msg[i]] += 1
		i+=1

	return {k: (v-1)/57 for k, v in sorted(computedLetterFrequency.items(), key=lambda item: item[1], reverse=True)}
	
def computeBiFrequency(msg: str) -> dict:
	i = 0
	computedBiFrequency = {}
	while i < len(msg) - 1:
		if isLetter(msg[i]) and isLetter(msg[i+1]):
			if msg[i:i+2] not in computedBiFrequency.keys():
				computedBiFrequency[msg[i:i+2]] = 1
			else:
				computedBiFrequency[msg[i:i+2]] += 1
		i+=1
	return {k: v for k, v in sorted(computedBiFrequency.items(), key=lambda item: item[1], reverse=True)}

def crackSub(msg: str) -> str:
	freq = computeLetterFrequency(msg)
	msgLen = len(msg)

	computedKey = {}
	i = 0
	while i < len(freq):
		computedKey[list(freq.keys())[i]] = list(LETTERS_FREQUENCIES.keys())[i]
		i+=1
		
	i = 0

	currentAttemt = chiffrerMono(msg, computedKey)
	currentLikeliness = 1
	currentKey = dict(computedKey)

	maxAttempt = str(currentAttemt)
	maxLikeliness = 1
	maxKey = dict(currentKey)

	while i < MAX_ITERATIONS:
		j = 0

		currentAttemt = chiffrerMono(msg, currentKey)
		currentLikeliness = 0

		while j < msgLen - 1:
			if currentAttemt[j] + currentAttemt[j+1] in PAIRS_FREQUENCIES.keys():
				currentLikeliness *= PAIRS_FREQUENCIES[currentAttemt[j] + currentAttemt[j+1]]
			elif isLetter(currentAttemt[j]) and isLetter(currentAttemt[j+1]):
				currentLikeliness *= 0.005
			j+=1
		
		if currentLikeliness > maxLikeliness:
			maxLikeliness = currentLikeliness
			maxAttempt = str(currentAttemt)
			maxKey = dict(currentKey)
			print(maxAttempt)
		elif maxLikeliness == 0 or rnd.random() > currentLikeliness/maxLikeliness: 
			rand1, rand2 = list(currentKey.keys())[rnd.randint(0, len(currentKey)-1)], list(currentKey.keys())[rnd.randint(0, len(currentKey)-1)]
			currentKey[rand1], currentKey[rand2] = currentKey[rand2], currentKey[rand1]
			
		i+=1
	return maxAttempt, maxLikeliness

print(crackSub("SD GKOQDIPRSK RLP SDR CIFTQDR OGPRR O'SDR SDQPR OR PKIQPRCRDP BSQ HRKCRPPIDP O'RXRFSPRK ORL HKGAKICCRL RDKRAQLPKRL. F'RLP SD RDLRCNBR OR FQKFSQPL RBRFPKGDQJSRL HRKCRPPIDP OR CIDQHSBRK ORL OGDDRRL LGSL MGKCR NQDIQKR, GS NQPL. FRPPR CIFTQDR HRKCRP OR PKIQPRK ORL QDMGKCIPQGDL LRBGD ORL LRJSRDFRL O'QDLPKSFPQGDL HKRORMQDQRL, IHHRBRRL ISLLQ HKGAKICCRL."))
#print(dechiffrerVigenere("DMVM FAM YOM ILSILI", "BITE"))