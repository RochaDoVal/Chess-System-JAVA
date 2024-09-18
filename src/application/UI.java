package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Color;

public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//Usando o git para da cor nas peças
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	
	// https://stackoverflow.com/
	//limpar a tela, quando fizer uma jogada... nao ficar poluido
	public static void clearScream() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	
	// na String vc vai escrever por exemplo (a1)
	// column vai pegar somente a primeira letra por isso o (s.charAt(0))
	// a Row/Linha vai pegar a segunda letra/numero por isso o (Integer.parseInt(s.substring(1))
	// em poucas palavras, estamos recortando, separando a letra do numero e colocando em Column e Row...
	// o try e para caso digite algo errado, foram da matriz... limite é de (a1 a h8)
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
		}
		
	}
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("turn: " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlay());
		if(chessMatch.getCheck()) {
			System.out.println("CHECK!");
		}
	}
		
		
	//Print do tabuleiro 
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i = 0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j<pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();	
		}
		System.out.println("  a b c d e f g h");
	}
	
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i = 0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for(int j = 0; j<pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();	
		}
		System.out.println("  a b c d e f g h");
	}
	
	//colorir
	private static void printPiece(ChessPiece piece, boolean background) {
    	if(background) {
    		System.out.print(ANSI_BLUE_BACKGROUND);
    	}
		if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
            	//esse seria o preto... porem colocamos amarelo por causa do git
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
	
	//responsavel por imprimir a lista de peça capturadas
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white =  captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black =  captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces:");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		//macete pra imprimir a lista/array
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		//macete pra imprimir a lista/array
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
	}
}
