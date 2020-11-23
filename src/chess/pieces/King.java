package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position poisition) {
		ChessPiece localPiece = (ChessPiece)getBoard().piece(poisition);
		return (localPiece == null) || (localPiece.getColor() != getColor());
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece localPiece = (ChessPiece)getBoard().piece(position);
		return localPiece != null && localPiece instanceof Rook && localPiece.getColor() == getColor() && localPiece.getMoveCount() == 0;
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
		
		//Castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			//Kingside Castling
			Position posKingRook = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posKingRook)) {
				Position posKingNear = new Position(position.getRow(), position.getColumn() + 1);
				Position posKingFar = new Position(position.getRow(), position.getColumn() + 2);
				
				if (getBoard().piece(posKingNear) == null && getBoard().piece(posKingFar) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			
			//Queenside Castling
			Position posQueenRook = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posQueenRook)) {
				Position posQueenNear = new Position(position.getRow(), position.getColumn() - 1);
				Position posQueenMiddle = new Position(position.getRow(), position.getColumn() - 2);
				Position posQueenFar = new Position(position.getRow(), position.getColumn() - 3);
				
				if (getBoard().piece(posQueenNear) == null && getBoard().piece(posQueenMiddle) == null && getBoard().piece(posQueenFar) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
		
		return mat;
	}
}
