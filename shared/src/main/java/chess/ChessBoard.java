package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    ChessPiece[][] squares;
    ChessPiece.PieceType[] backRank = {
        ChessPiece.PieceType.ROOK,
        ChessPiece.PieceType.KNIGHT,
        ChessPiece.PieceType.BISHOP,
        ChessPiece.PieceType.QUEEN,
        ChessPiece.PieceType.KING,
        ChessPiece.PieceType.BISHOP,
        ChessPiece.PieceType.KNIGHT,
        ChessPiece.PieceType.ROOK
    };

    public ChessBoard() {
        squares = new ChessPiece[8][8];
//        resetBoard();
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow()-1][position.getColumn()-1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        squares = new ChessPiece[8][8];
        for (int i=0; i < 8; i++) {
            squares[7][i] = new ChessPiece(ChessGame.TeamColor.BLACK, backRank[i]);
            squares[6][i] = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);

            squares[0][i] = new ChessPiece(ChessGame.TeamColor.WHITE, backRank[i]);
            squares[1][i] = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(squares, that.squares) && Objects.deepEquals(backRank, that.backRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.deepHashCode(squares), Arrays.hashCode(backRank));
    }
}
