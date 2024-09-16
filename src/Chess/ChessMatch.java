package Chess;

import java.util.ArrayList;
import java.util.List;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;


public class ChessMatch {
	
	private int turn;
	private Color currentPlay;
	private Board board;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	//Tamnaho do tabuleiro
	//E setup das peças
	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlay = Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlay() {
		return currentPlay;
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
	
	//converte a posição de xadrez para posição de xadrez normal
	//depois validar a posição
	//por ultimo returnar os movimento possiveis.
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
		
	}
	
	//Priemiro converte para posição da Matriz
	//Apos isso tem que validar se tinha um peça onde foi selecionado
	//makeMove, responsavel pela movimentaçao da peça
	//Depois retorna a peça capiturada e fazer DownCast para (ChessPiece), pq a peça capturada é do tipo Piece.
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece)capturedPiece;
	}
	
	//Testa se tem um peça na posição de origem
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		
		//se a cor for diferente da cor atual, significa que a peça nao é dele.
		if(currentPlay != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		
		//se nao tiver nem um movimento possivel...
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	//testando se na peça de origem para a posição de destino é possivel.
	private void validateTargetPosition (Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen can't move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlay = (currentPlay == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	
	//vai retirar a peça da posiçao de origem e remover a possivel peça que esta na posiçao de destino
	//e depois coloca a peça a peça onde foi capturada. (Se tiver uma peça la, caso nao so coloca mesmo.)
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);	
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		//tirar da lista de peça no tabuleiro e colocar na lista de capturadas
		if(capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	//coloca a peça no taboleiro e coloca na lista de peças no tabuleiro
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
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
