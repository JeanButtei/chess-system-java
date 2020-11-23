package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}
	
	private boolean canMove(Position poisition) {
		ChessPiece localPiece = (ChessPiece)getBoard().piece(poisition);
		return (localPiece == null) || (localPiece.getColor() != getColor());
	}

	@Override
	public boolean[][] possibleMoves() {		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position localPosition = new Position(0, 0); //aux
		
		localPosition.setValues(position.getRow() - 1, position.getColumn() - 2);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		localPosition.setValues(position.getRow() -2, position.getColumn() - 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		localPosition.setValues(position.getRow() - 2, position.getColumn() + 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		localPosition.setValues(position.getRow() - 1, position.getColumn() + 2);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		localPosition.setValues(position.getRow() + 1, position.getColumn() + 2);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		localPosition.setValues(position.getRow() + 2, position.getColumn() + 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}

		localPosition.setValues(position.getRow() + 2, position.getColumn() - 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}

		localPosition.setValues(position.getRow() + 1, position.getColumn() - 2);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "N";
	}	

}
