package com.snakeLadder.rules;

import com.snakeLadder.dice.DiceState;
import com.snakeLadder.log.LogPrinter;
import com.snakeLadder.players.Player;
import com.snakeLadder.structure.Board;
import com.snakeLadder.structure.Square;

import java.util.Optional;

public class SnakeLadderMove {

    public Optional<Square> move(Player player, DiceState diceState, Board board, Optional<Square> newSquare, boolean shouldPrintLog) {
        if (newSquare.get().hasSnakeOrLadder()) {
            if(shouldPrintLog) {
                LogPrinter.printSnakeLadderInformation(player, diceState, newSquare, newSquare.get().getSnakeOrLadder().get());
            }

            int snakeLadderEndingSquareDisplayNumber = newSquare.get().getSnakeOrLadder().get().getEndingSquare().getDisplayNumber();
            newSquare = Optional.of(board.getSquareHavingDisplayNumber(snakeLadderEndingSquareDisplayNumber));
        }
        return newSquare;
    }
}
