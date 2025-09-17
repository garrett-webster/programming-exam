package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessPosition;

public class KnightMoveCalculator extends MoveCalculator {
    int[][] knightMoveOffsets = {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
    };

    public KnightMoveCalculator(ChessPosition position, ChessBoard board) {
        super(position, board);
        addMovesFromOffsets(knightMoveOffsets);
    }
}
