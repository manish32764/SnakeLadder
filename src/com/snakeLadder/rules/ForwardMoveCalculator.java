package com.snakeLadder.rules;

import com.snakeLadder.log.LogPrinter;
import com.snakeLadder.structure.Board;
import com.snakeLadder.dice.DiceState;
import com.snakeLadder.players.Player;
import com.snakeLadder.structure.Square;

import java.util.Optional;

public class ForwardMoveCalculator {

    private final FirstMoveRule firstMoveRule = new FirstMoveRule();
    private final SnakeLadderMove snakeLadderMove = new SnakeLadderMove();

    public Optional<Square> getNewPosition(Player player, DiceState diceState, Board board, boolean shouldPrintLog) {
        Optional<Square> newSquare = Optional.empty();

        if (firstMoveRule.canMove(player, diceState)) {
            int currentSquareDisplayNumber = player.hasMadeFirstMove() ? player.getCurrentPosition().get().getDisplayNumber() : 0;

            int newSquareDisplayNumber = currentSquareDisplayNumber + diceState.getNumber();
            newSquareDisplayNumber = newSquareDisplayNumber > board.getLastSquareDisplayNumber() ? currentSquareDisplayNumber : newSquareDisplayNumber;

            newSquare = snakeLadderMove.move(player, diceState, board, Optional.of(board.getSquareHavingDisplayNumber(newSquareDisplayNumber)), shouldPrintLog);
        }
        return newSquare;
    }


}
