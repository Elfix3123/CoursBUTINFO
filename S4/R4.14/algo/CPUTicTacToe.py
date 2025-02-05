from enum import Enum

class Mark(Enum):
	X = 1
	O = -1
	EMPTY = 0

class Move:
	def __init__(self, row = -1, col = -1):
		self.row = row
		self.col = col

class Board:
	def __init__(self, board = None) -> None:
		if board is None:
			self.board = [[Mark.EMPTY for j in range(3)] for i in range(3)]
		else:
			self.board = [[board[i][j] for j in range(3)] for i in range(3)]
		
	def play(self, move: Move, mark: Mark) -> None:
		self.board[move.row][move.col] = mark
	
	def evaluate(self, mark: Mark) -> Mark:
		if self.board[0][0] == self.board[0][1] == self.board[0][2]:
			return self.board[0][0]
		elif self.board[1][0] == self.board[1][1] == self.board[1][2]:
			return self.board[1][0]
		elif self.board[2][0] == self.board[2][1] == self.board[2][2]:
			return self.board[2][0]
		elif self.board[0][0] == self.board[1][0] == self.board[2][0]:
			return self.board[0][0]
		elif self.board[0][1] == self.board[1][1] == self.board[2][1]:
			return self.board[0][1]
		elif self.board[0][2] == self.board[1][2] == self.board[2][2]:
			return self.board[0][2]
		elif self.board[0][0] == self.board[1][1] == self.board[2][2]:
			return self.board[0][0]
		elif self.board[0][2] == self.board[1][1] == self.board[2][0]:
			return self.board[0][2]
		elif all([self.board[i][j] != Mark.EMPTY for i in range(3) for j in range(3)]):
			return Mark.EMPTY
		else:
			return None
	
	def generateMoves(self) -> list:
		moves = []
		for i in range(3):
			for j in range(3):
				if self.board[i][j] == Mark.EMPTY:
					moves.append(Move(i, j))
		return moves

	def __str__(self) -> str:
		return '\n'.join([' '.join([str(self.board[i][j].value) for j in range(3)]) for i in range(3)])

