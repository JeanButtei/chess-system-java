package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position poisition) {
		ChessPiece localPiece = (ChessPiece)getBoard().piece(poisition);
		return (localPiece == null) || (localPiece.getColor() != getColor());
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position localPosition = new Position(0, 0); //aux
		
		//Above
		localPosition.setValues(position.getRow() - 1, position.getColumn());
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//Below
		localPosition.setValues(position.getRow() + 1, position.getColumn());
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//Left		
		localPosition.setValues(position.getRow(), position.getColumn() - 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//Right
		localPosition.setValues(position.getRow(), position.getColumn() + 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//NW
		localPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//NE
		localPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}

		//SW
		localPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}

		//SE
		localPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		if ((getBoard().positionExists(localPosition)) && (canMove(localPosition))) {
			mat[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		return mat;
	}
}
