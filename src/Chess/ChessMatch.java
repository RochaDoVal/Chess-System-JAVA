package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
	
	private Board board;
	
	//Tamnaho do tabuleiro
	//E setup das peças
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	//Aqui é o setup padrão das peças do Xadrez
	private void initialSetup() {
		placeNewPiece('b', 6,new Rook(board, Color.WHITE));
		placeNewPiece('e', 8,new King(board, Color.BLACK));
		placeNewPiece('e', 1,new King(board, Color.BLACK));
	}
}
