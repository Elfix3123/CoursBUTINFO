import re

class Interface:
	def __init__(self, id: str, cidr: str):
		self.__id = id
		self.__cidr = cidr
	
	def getId(self) -> str:
		return self.__id
	
	def getCidr(self) -> str:
		return self.__cidr
	
	def getIp(self) -> str:
		return re.match(r'(.*)\/', self.__cidr)
	
	def getSuffix(self) -> str:
		return re.match(r'\/(.*)', self.__cidr)