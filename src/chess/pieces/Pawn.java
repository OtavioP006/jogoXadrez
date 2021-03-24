package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if(getColor() == Color.WHITE) {
			
			// Avanço/Peao branco
			p.setValues(position.getRow() -1, position.getColumn());
			
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Avanço inicial/Peao Branco
			p.setValues(position.getRow() -2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
		
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Diagonal esquerda/ Peao Branco
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Diagonal direita/ Peao Branco
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		else {
		// Avanço/Peao Preto
			p.setValues(position.getRow() +1, position.getColumn());
			
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Avanço inicial/Peao Preto
			p.setValues(position.getRow() +2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
		
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// Diagonal esquerda/ Peao Preto
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			// Diagonal direita/ Peao Peao Preto
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
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


