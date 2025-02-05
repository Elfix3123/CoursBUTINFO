import java.util.ArrayList;
import java.util.Arrays;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
	private Mark[][] board;

	// Ne pas changer la signature de cette méthode
	public Board() {
		board = new Mark[3][3];
		for (int i=0; i<3;i++) {
			for (int j=0; j<3;j++) {
				board[i][j] = Mark.EMPTY;
			}
		}
	}

	public Board(Board copyBoard) {
		board = new Mark[3][3];
		for (int i=0; i<3;i++) {
			for (int j=0; j<3;j++) {
				board[i][j] = copyBoard.board[i][j];
			}
		}
	}

	// Place la pièce 'mark' sur le plateau, à la
	// position spécifiée dans Move
	//
	// Ne pas changer la signature de cette méthode
	public void play(Move m, Mark mark){
		board[m.getRow()][m.getCol()] = mark;
	}


	// Retourne  100 pour une victoire
	//          -100 pour une défaite
	//           0   pour un match nul
	// Ne pas changer la signature de cette méthode
	public int evaluate(Mark mark){
		Mark winningMark = Mark.EMPTY;
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != Mark.EMPTY) {
			winningMark = board[0][0];
		} else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != Mark.EMPTY) {
			winningMark = board[1][0];
		} else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != Mark.EMPTY) {
			winningMark = board[2][0];
		} else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != Mark.EMPTY) {
			winningMark = board[0][0];
		} else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != Mark.EMPTY) {
			winningMark = board[0][1];
		} else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != Mark.EMPTY) {
			winningMark = board[0][2];
		} else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Mark.EMPTY) {
			winningMark = board[0][0];
		} else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Mark.EMPTY) {
			winningMark = board[0][2];
		}

		if (winningMark == mark) {
			return 100;
		} else if (winningMark != Mark.EMPTY) {
			return -100;
		}
		else {
			return 0;
		}
	}

	// Retourne  true si la partie est terminée (victoire, défaite, match nul
	//           false sinon
	//           
	// Ne pas changer la signature de cette méthode
	public boolean isGameFinished(){
		return evaluate(Mark.O) != 0 || generateMoves().size() == 0;
	}


	// Retourne une liste des coups qu'il est possible
	// de jouer en fonction de l'état du plateau
	//
	// Ne pas changer la signature de cette méthode
	public ArrayList<Move> generateMoves(){
		ArrayList<Move> moves = new ArrayList<Move>();
		
		int i = 0, j;
		while (i < board.length) {
			j = 0;

			while (j < board[i].length) {
				if (board[i][j] == Mark.EMPTY) {
					moves.add(new Move(i, j));
				}
				j++;
			}

			i++;
		}

		return moves;
	}

	// Affiche le plateau de jeu
	//
	// Ne pas changer la signature de cette méthode
	public void print(){
		for(int i=0; i<3;i++){
			for(int j=0; j<3;j++){
				if(board[i][j] == Mark.EMPTY)
					System.out.print(" ");
				else
					System.out.print(board[i][j]);
				if(j<2)
					System.out.print(" | ");
			}
			System.out.println("");
			if (i < 2)
				System.out.println("----------");
		}
		System.out.println("\n");
	}
}
