package application;

import Chess.ChessMatch;

public class Program {
	public static void main (String[] args) {
//abra a pasta BIN e abra o terminal git, e digite -> java application/Program

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}
}
