package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Position position, Board board) {
		super();
		this.position = position;
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}

	
	
	
	
	
}