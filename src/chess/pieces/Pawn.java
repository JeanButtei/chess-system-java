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
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position localPosition = new Position(0, 0); //aux

		if (getColor() == Color.WHITE) {
			localPosition.setValues(position.getRow() - 1, position.getColumn());			
			if (getBoard().positionExists(localPosition) && !getBoard().thereIsAPiece(localPosition)) {
				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}

			localPosition.setValues(position.getRow() - 2, position.getColumn());
			Position whitePawnFront = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(localPosition) && !getBoard().thereIsAPiece(localPosition) &&
					getBoard().positionExists(whitePawnFront) && !getBoard().thereIsAPiece(whitePawnFront) &&
					getMoveCount() == 0) {

				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}

			localPosition.setValues(position.getRow() - 1, position.getColumn() - 1);			
			if (getBoard().positionExists(localPosition) && isThereOpponentPiece(localPosition)) {
				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}

			localPosition.setValues(position.getRow() - 1, position.getColumn() + 1);			
			if (getBoard().positionExists(localPosition) && isThereOpponentPiece(localPosition)) {
				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}
		}
		else {
			localPosition.setValues(position.getRow() + 1, position.getColumn());			
			if (getBoard().positionExists(localPosition) && !getBoard().thereIsAPiece(localPosition)) {
				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}

			localPosition.setValues(position.getRow() + 2, position.getColumn());
			Position blackPawnFront = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(localPosition) && !getBoard().thereIsAPiece(localPosition) &&
					getBoard().positionExists(blackPawnFront) && !getBoard().thereIsAPiece(blackPawnFront) &&
					getMoveCount() == 0) {

				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}

			localPosition.setValues(position.getRow() + 1, position.getColumn() + 1);			
			if (getBoard().positionExists(localPosition) && isThereOpponentPiece(localPosition)) {
				moves[localPosition.getRow()][localPosition.getColumn()] = true;
			}

			localPosition.setValues(position.getRow() + 1, position.getColumn() - 1);			
			if (getBoard().positionExists(localPosition) && isThereOpponentPiece(localPosition)) {
				moves[localPosition.getRow()][localPosition.getColumn()] = true;			
			}
		}

		return moves;
	}

}
