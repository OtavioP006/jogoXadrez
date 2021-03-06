package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		while (!match.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(match, captured);
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

				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}

				if (match.getPromoted() != null) {
					System.out.print("Entre com para qual peca promover (Q/N/R/B): ");
					String type = input.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Tipo invalido: Digite (Q/N/R/B): ");
						type = input.nextLine().toUpperCase();
						match.replacePromotedPiece(type);
					}

				}
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}

			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(match, captured);

	}

}
