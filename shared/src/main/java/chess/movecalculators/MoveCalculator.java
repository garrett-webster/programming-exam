package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;

public class MoveCalculator {
    int[][] diagModifiers = {
            {1,1},
            {1,-1},
            {-1,1},
            {-1,-1}
    };

    ArrayList<ChessMove> moves;
    ChessPosition position;
    ChessBoard board;
    ChessPiece piece;
    int row;
    int col;

    MoveCalculator(ChessPosition position, ChessBoard board) {
        moves = new ArrayList<>();
        this.position = position;
        this.board = board;
        this.piece = board.getPiece(position);
        this.row = position.getRow();
        this.col = position.getColumn();
    }

    public void addMovesFromMods (int[][] modifiers) {
        for (int[] mods: modifiers) {
            for (int i = 1; isInBounds(row+i*mods[0], col+i*mods[1]); i++) {
                if (checkCollisionAndAddMove(row+i*mods[0], col+i*mods[1])) {
                    break;
                }
            }
        }
    }

    private boolean isInBounds(int row, int col) {
        return row > 0 && row < 9 && col > 0 && col < 9;
    }

    private boolean isCollision(int row, int col) {
        return board.squares[row - 1][col - 1] != null;
    }

    private boolean checkCollisionAndAddMove(int row, int col) {
        if (isCollision(row, col)) {
            if (board.squares[row - 1][col - 1].getTeamColor() != piece.getTeamColor()) {
                moves.add(new ChessMove(position, new ChessPosition(row, col), null));
            }
            return true;
        }
        moves.add(new ChessMove(position, new ChessPosition(row, col), null));
        return false;
    }

    public ArrayList<ChessMove> getMoves() {
        return moves;
    }
}
