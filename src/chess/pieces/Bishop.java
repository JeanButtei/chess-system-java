package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);		
	}

	@Override
	public boolean[][] possibleMoves() {		
boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position localPosition = new Position(0, 0); //aux
		
		//NW
		localPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setValues(localPosition.getRow() - 1, localPosition.getColumn() - 1);
		}
		
		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//NE
		localPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setValues(localPosition.getRow() - 1, localPosition.getColumn() + 1);
		}

		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//SW
		localPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setValues(localPosition.getRow() + 1, localPosition.getColumn() - 1);
		}

		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//SE
		localPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setValues(localPosition.getRow() + 1, localPosition.getColumn() + 1);
		}

		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		return moves;
	}

	@Override
	public String toString() {
		return "B";
	}

}
