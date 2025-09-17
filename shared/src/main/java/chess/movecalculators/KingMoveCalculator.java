package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessPosition;

public class KingMoveCalculator extends MoveCalculator {
    int[][] kingMoveOffsets = {
            {1,1},
            {1,0},
            {1,-1},
            {0,1},
            {0,-1},
            {-1,1},
            {-1,0},
            {-1,-1},
    };

    public KingMoveCalculator(ChessPosition position, ChessBoard board) {
        super(position, board);
        addMovesFromOffsets(kingMoveOffsets);
    }
}
