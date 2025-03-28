import yaml
from _io import TextIOWrapper

class Parser:
	def __init__(self, f: TextIOWrapper):
		print(yaml.load(f, yaml.CLoader))

if __name__ == "__main__":
	Parser(open("grosort/tests.yaml"))