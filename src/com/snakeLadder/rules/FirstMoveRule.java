package com.snakeLadder.rules;

import com.snakeLadder.dice.DiceState;
import com.snakeLadder.players.Player;

public class FirstMoveRule {

    public boolean canMove(Player player, DiceState diceState){
        return player.hasMadeFirstMove() || diceState == DiceState.SIX;
    }
}
