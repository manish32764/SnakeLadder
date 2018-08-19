package com.snakeLadder.dice;

import com.snakeLadder.exception.InvalidDiceStateException;

public enum DiceState {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int number;

    DiceState(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static DiceState getState(int number){
        for(DiceState diceState : DiceState.values()){
            if(diceState.getNumber() == number){
                return diceState;
            }
        }
        throw new InvalidDiceStateException(number);
    }
}
