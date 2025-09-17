package chess;

import chess.movecalculators.*;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    ChessGame.TeamColor teamColor;
    PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, PieceType type) {
        this.teamColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return teamColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        MoveCalculator moveCalculator = null;
        if (type == PieceType.KING) {
            moveCalculator = new KingMoveCalculator(myPosition, board);
        } else if (type == PieceType.QUEEN) {
            moveCalculator = new QueenMoveCalculator(myPosition, board);
        } else if (type == PieceType.BISHOP) {
            moveCalculator = new BishopMoveCalculator(myPosition, board);
        } else if (type == PieceType.KNIGHT) {
            moveCalculator = new KnightMoveCalculator(myPosition, board);
        } else if (type == PieceType.ROOK) {
            moveCalculator = new RookCalculator(myPosition, board);
        } else if (type == PieceType.PAWN) {
            moveCalculator = new PawnMoveCalculator(myPosition, board);
        }

        return moveCalculator.getMoves();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return teamColor == that.teamColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamColor, type);
    }
}
