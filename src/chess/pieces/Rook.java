package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);		
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {		
		boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position localPosition = new Position(0, 0); //aux
		
		//Above
		localPosition.setValues(position.getRow() - 1, position.getColumn());
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setRow(localPosition.getRow() - 1);
		}
		
		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//Left
		localPosition.setValues(position.getRow(), position.getColumn() - 1);
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setColumn(localPosition.getColumn() - 1);
		}

		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//Right
		localPosition.setValues(position.getRow(), position.getColumn() + 1);
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setColumn(localPosition.getColumn() + 1);
		}

		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		//Below
		localPosition.setValues(position.getRow() + 1, position.getColumn());
		while ((getBoard().positionExists(localPosition)) && (!getBoard().thereIsAPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
			localPosition.setRow(localPosition.getRow() + 1);
		}

		if ((getBoard().positionExists(localPosition)) && (isThereOpponentPiece(localPosition))) {
			moves[localPosition.getRow()][localPosition.getColumn()] = true;
		}
		
		return moves;
	}

}
