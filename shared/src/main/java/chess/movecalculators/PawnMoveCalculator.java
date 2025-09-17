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

    public PawnMoveCalculator(ChessPosition position, ChessBoard board) {
        super(position, board);

        if (board.getPiece(position).getTeamColor() == ChessGame.TeamColor.WHITE) {
            direction = 1;
        } else {
            direction = -1;
        }
    }

    @Override
    public ArrayList<ChessMove> getMoves() {
        // Move one forward
        if (!isCollision(row + direction, col)) {
            addPawnMove(row + direction, col);
        }

        // Move two forward

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
