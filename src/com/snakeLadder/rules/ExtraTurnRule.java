package com.snakeLadder.rules;

import com.snakeLadder.log.LogPrinter;
import com.snakeLadder.structure.Board;
import com.snakeLadder.dice.DiceState;
import com.snakeLadder.players.Player;
import com.snakeLadder.structure.Square;

import java.util.Optional;

public class ExtraTurnRule {

    private final ForwardMoveCalculator forwardMoveCalculator = new ForwardMoveCalculator();

    public boolean isEligible(Player currentPlayer, DiceState diceState, Board board){
        Optional<Square> newSquare = forwardMoveCalculator.getNewPosition(currentPlayer, diceState, board, true);

        boolean playerAttacked = newSquare.isPresent() ? validAttack(currentPlayer, newSquare) : false;

        LogPrinter.printExtraTurnAllowed(playerAttacked, diceState, currentPlayer, newSquare);
        return diceState == DiceState.SIX || playerAttacked;
    }

    private boolean validAttack(Player currentPlayer, Optional<Square> newSquare) {
        Optional<Player> currentPositionedPlayer = newSquare.get().getCurrentPositionedPlayer();
        return currentPositionedPlayer.isPresent() ? !currentPositionedPlayer.get().getName().equals(currentPlayer.getName()) : false;
    }
}
