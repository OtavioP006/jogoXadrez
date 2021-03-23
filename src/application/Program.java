package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		while (true) {
			try {
				UI.clearScreen();
				UI.printMatch(match);
				System.out.println();
				System.out.print("Source:");		
				ChessPosition source = UI.readChessPosition(input);
				
				boolean[][] possibleMoves = match.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(match.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(input);
				
				
				
				
				ChessPiece capturedPiece = match.performChessMove(source, target);
				

			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
			
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
			
	}

}
