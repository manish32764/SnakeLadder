package com.snakeLadder.snakeLadder;

import com.snakeLadder.structure.Square;

public class SnakeOrLadder {
    public final Square startingSquare;
    public final Square endingSquare;
    public final SnakeLadderType snakeLadderType;

    public SnakeOrLadder(Square startingPosition, Square endingSquare, SnakeLadderType snakeLadderType) {
        this.startingSquare = startingPosition;
        this.endingSquare = endingSquare;
        this.snakeLadderType = snakeLadderType;
    }

    public Square getStartingSquare() {
        return startingSquare;
    }

    public Square getEndingSquare() {
        return endingSquare;
    }

    public SnakeLadderType getSnakeLadderType() {
        return snakeLadderType;
    }

    @Override
    public String toString() {
        return  " snakeOrLadder=" + snakeLadderType +
                ", starting=" + startingSquare.getDisplayNumber() +
                ", ending=" + endingSquare.getDisplayNumber() +
                '}';
    }
}
