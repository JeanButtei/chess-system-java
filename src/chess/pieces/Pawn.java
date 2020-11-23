package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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
			
			//En Passant
			if (position.getRow() == 3) {
				Position left = new Position (position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					moves[left.getRow() - 1][left.getColumn()] = true;
				}
				
				Position right = new Position (position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					moves[right.getRow() - 1][right.getColumn()] = true;
				}
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
			
			//En Passant
			if (position.getRow() == 4) {
				Position left = new Position (position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					moves[left.getRow() + 1][left.getColumn()] = true;
				}
				
				Position right = new Position (position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					moves[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}

		return moves;
	}

}
