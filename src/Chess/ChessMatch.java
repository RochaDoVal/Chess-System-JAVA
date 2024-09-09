package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Piece;
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
	
	//Priemiro converte para posição da Matriz
	//Apos isso tem que validar se tinha um peça onde foi selecionado
	//makeMove, responsavel pela movimentaçao da peça
	//Depois retorna a peça capiturada e fazer DownCast para (ChessPiece), pq a peça capturada é do tipo Piece.
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	//Testa se tem um peça na posição de origem
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		//se nao tiver nem um movimento possivel...
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	//vai retirar a peça da posiçao de origem e remover a possivel peça que esta na posiçao de destino
	//e depois coloca a peça a peça onde foi capturada. (Se tiver uma peça la, caso nao so coloca mesmo.)
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);	
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
		}
	
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	//Aqui é o setup padrão das peças do Xadrez
	//abra a pasta BIN e abra o terminal git, e digite -> java application/Program
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
