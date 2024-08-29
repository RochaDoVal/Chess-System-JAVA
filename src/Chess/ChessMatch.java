package Chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	//Tamnaho do tabuleiro
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	//retornar uma matriz de peças de xadrez
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//pecorrer a matriz e fazer um downcast da matriz para ChessPiece
		for( int i = 0; i<board.getRows(); i++) {
			for( int j = 0; j<board.getRows(); j++){
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
}
