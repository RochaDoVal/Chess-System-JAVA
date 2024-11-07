package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;
import boardgame.Position;

public class Pawn extends ChessPiece{
	
	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	
	@Override
	public boolean [][] possibleMoves(){
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];	
		
		Position p = new Position (0, 0);
		
		//IF (Se a posicao existir e se estiver vazia, pode ir.)
		if(getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//IF (Se a posicao P existir e se  P esta vazia e se P2 existe e esta vazia e quantidade de movimentos do PEAO seja == 0)
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//IF se a posiçao existe  e se tem um peça oponente la.
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//IF se a posiçao existe  e se tem um peça oponente la.
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		else { //PEAO PRETO ENTAO é MAIS +
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
