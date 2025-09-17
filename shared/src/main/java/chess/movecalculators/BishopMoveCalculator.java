package chess.movecalculators;

import chess.ChessBoard;
import chess.ChessPosition;

public class BishopMoveCalculator extends MoveCalculator {
    public BishopMoveCalculator(ChessPosition position, ChessBoard board) {
        super(position, board);
        addMovesFromMods(diagModifiers);
    }
}
