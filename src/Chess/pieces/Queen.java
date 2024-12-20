package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position (0, 0);
		
		// Mesma coisa da ROOK
		
		// above | acima
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, andar mais um linha. 
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// left | esquerda
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, subir andar um linha. 
		p.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// right | direita
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, subir andar um linha. 
		p.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// below | baixo
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, andar mais um linha. 
		p.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Mesma coisa do BISHOP
		
		// NOROESTE
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, andar mais um linha. 
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// NORDESTE
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, subir andar um linha. 
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// SUDESTE
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, subir andar um linha. 
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// SUDOESTE
		// enquanto a posição existir e nao tiver uma peça la, = TRUE
		// depois fazer isso novamente, andar mais um linha. 
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		// se a posição existe e se a um oponente no local = TRUE
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
	
	

}
