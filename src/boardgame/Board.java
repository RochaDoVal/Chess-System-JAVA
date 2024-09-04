package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		//programação defensiva
		if(rows < 1 || columns <1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 colmun");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
	public Piece piece (int row, int column) {
		//programação defensiva
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		//programação defensiva --- se a posição existe
		if(!positionExists(position)) {
			throw new BoardException("POsition not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//metodo vai colocar uma peça na posição desejeda
	//a peça vai deixa de ser Null e receberar uma position
	public void placePiece(Piece piece, Position position) {
		//Programaçao defensiva---Testar se ja existe uma peça na posição... 
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		
		
	}
	//fica mais facil testar pela linha e pela coluna...
	// a linha tem que ser maior que 0 && menor que a altura do taabuleiro
	// mesma coisa pra coluna
	public Boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
		
	}
	//reaproveita o metodo de cima...
	public Boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//testa se tem um peça nessa posição
	public boolean thereIsAPiece(Position position) {
		//programação defensiva -- se a posição existe
		if(!positionExists(position)) {
			throw new BoardException("POsition not on the board");
		}
		return piece(position) != null;
	}
	
	
}
