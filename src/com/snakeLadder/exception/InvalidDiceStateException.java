package com.snakeLadder.exception;

public class InvalidDiceStateException extends RuntimeException {

    public InvalidDiceStateException(int number) {
        super("Invalid Dice State : " + number);
    }
}
