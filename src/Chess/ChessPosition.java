package Chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		//programação defensiva -- referente a coluna e a linha
		if(column < 'a' || column > 'h' || row < 1 || row >8) {
			throw new ChessException("Error instantiating CHessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	//convertendo para o padrão xadrez 
	// na matriz normal a posição a8 seria igual a 0,0
	//por isso fazemos 8-8 que daria 0
	//matrix_row = 8 - chess_row 
	//matrix_column = chess_column - 'a'
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//Matriz para xadrez
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}

	@Override
	public String toString() {
		return "" + column + row;
	}
	
	

}
