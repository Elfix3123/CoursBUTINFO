import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{
	Mark cpuMark;
	// Contient le nombre de noeuds visités (le nombre
	// d'appel à la fonction MinMax ou Alpha Beta)
	// Normalement, la variable devrait être incrémentée
	// au début de votre MinMax ou Alpha Beta.
	private int numExploredNodes;

	// Le constructeur reçoit en paramètre le
	// joueur MAX (X ou O)
	public CPUPlayer(Mark cpu){
		cpuMark = cpu;
		numExploredNodes = 0;
	}

	// Ne pas changer cette méthode
	public int  getNumOfExploredNodes(){
		return numExploredNodes;
	}

	// Retourne la liste des coups possibles.  Cette liste contient
	// plusieurs coups possibles si et seuleument si plusieurs coups
	// ont le même score.
	public ArrayList<Move> getNextMoveMinMax(Board board)
	{
		return new ArrayList<Move>(getNextMoveMinMaxWorker(board, cpuMark).keySet());
	}

	public HashMap<Move, Integer> getNextMoveMinMaxWorker(Board board, Mark playing) {
		numExploredNodes++;
		HashMap<Move, Integer> moves = new HashMap<Move, Integer>();
		for (Move move : board.generateMoves()) {
			Board newBoard = new Board(board);
			newBoard.play(move, playing);
			if (newBoard.isGameFinished()) {
				moves.put(move, newBoard.evaluate(playing));
			} else {
				moves.put(move, getNextMoveMinMaxWorker(newBoard, (playing == Mark.X) ? Mark.O : Mark.X).values().iterator().next());
			}
		}
		int pivot;
		if (playing == this.cpuMark) {
			pivot = Collections.max(moves.values());
		}
		else {
			pivot = Collections.min(moves.values());
		}
		for (Move move : moves.keySet()) {
			if (moves.get(move) == pivot) {
				moves.put(move, pivot);
			}
		}
		return moves;
	}

	// Retourne la liste des coups possibles.  Cette liste contient
	// plusieurs coups possibles si et seuleument si plusieurs coups
	// ont le même score.
	public ArrayList<Move> getNextMoveAB(Board board){
		numExploredNodes = 0;

	}

}
