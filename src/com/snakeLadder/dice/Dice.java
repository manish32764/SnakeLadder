package com.snakeLadder.dice;

import java.util.Random;

public class Dice {
    private DiceState currentState;
    private final Random random = new Random();

    public DiceState generateNewState(){
        int number = 1 + random.nextInt(6);
        currentState = DiceState.getState(number) ;
        return currentState;
    }

    public DiceState getCurrentState() {
        return currentState;
    }
}
