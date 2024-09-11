package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		super();
		this.board = board;
		position = null;
		
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();
 	
	//testar se a peça pode mover para uma determinada posição
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//Virificar se tem alguma posição possivel para a peçaa se mover em toda a matriz
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for( int i = 0; i< mat.length; i++){
			for( int j = 0; j< mat.length; j++){
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
