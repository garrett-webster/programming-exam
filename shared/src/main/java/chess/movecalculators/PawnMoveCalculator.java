package chess.movecalculators;

import chess.*;

import java.util.ArrayList;

public class PawnMoveCalculator extends MoveCalculator {
    ChessPiece.PieceType[] promotableTypes = {
            ChessPiece.PieceType.QUEEN,
            ChessPiece.PieceType.ROOK,
            ChessPiece.PieceType.KNIGHT,
            ChessPiece.PieceType.BISHOP
    };

    int direction;
    boolean canMoveTwice = false;

    public PawnMoveCalculator(ChessPosition position, ChessBoard board) {
        super(position, board);

        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
            direction = 1;

            if (row == 2) {
                canMoveTwice = true;
            }
        } else {
            direction = -1;

            if (row == 7) {
                canMoveTwice = true;
            }
        }
    }

    @Override
    public ArrayList<ChessMove> getMoves() {
        // Move one forward
        if (isInBounds(row + direction, col) && !isCollision(row + direction, col)) {
            addPawnMove(row + direction, col);

            // Move two forward
            if (isInBounds(row + direction*2, col) && !isCollision(row + direction*2, col) && canMoveTwice) {
                addPawnMove(row + direction*2, col);
            }
        }

        // Captures

        return moves;
    }

    private void addPawnMove(int row, int col) {
        if (row == 1 || row == 8) {
            for (ChessPiece.PieceType type: promotableTypes) {
                moves.add(new ChessMove(position, new ChessPosition(row, col), type));
            }
        } else {
            moves.add(new ChessMove(position, new ChessPosition(row, col), null));
        }
    }
}
