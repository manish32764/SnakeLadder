package com.snakeLadder.structure;

import com.snakeLadder.players.Player;
import com.snakeLadder.snakeLadder.SnakeOrLadder;

import java.util.Objects;
import java.util.Optional;

public class Square {

    private final int displayNumber;
    private final Colour colour;
    private Optional<SnakeOrLadder> snakeOrLadder;
    private Optional<Player> currentPositionedPlayer = Optional.empty();

    public Square(int displayNumber, Colour colour, Optional<SnakeOrLadder> snakeOrLadder) {
        this.displayNumber = displayNumber;
        this.colour = colour;
        this.snakeOrLadder = snakeOrLadder;
    }

    public void setSnakeOrLadder(Optional<SnakeOrLadder> snakeOrLadder) {
        this.snakeOrLadder = snakeOrLadder;
    }

    public int getDisplayNumber() {
        return displayNumber;
    }

    public Colour getColour() {
        return colour;
    }

    public Optional<SnakeOrLadder> getSnakeOrLadder() {
        return snakeOrLadder;
    }

    public Optional<Player> getCurrentPositionedPlayer() {
        return currentPositionedPlayer;
    }

    public boolean hasSnakeOrLadder(){
        return snakeOrLadder.isPresent();
    }

    public boolean hasPositionedPlayer(){
        return currentPositionedPlayer.isPresent();
    }

    public void setCurrentPositionedPlayer(Optional<Player> currentPositionedPlayer) {
        this.currentPositionedPlayer = currentPositionedPlayer;
    }

    @Override
    public String toString() {
        return "Square{" +
                "displayNumber=" + displayNumber +
                ", colour=" + colour +
                ", snakeOrLadder=" + snakeOrLadder +
                ", currentPositionedPlayer=" + currentPositionedPlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;
        return displayNumber == square.displayNumber &&
                colour == square.colour &&
                Objects.equals(snakeOrLadder, square.snakeOrLadder) &&
                Objects.equals(currentPositionedPlayer.get().getName(), square.currentPositionedPlayer.get().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayNumber, colour, snakeOrLadder, currentPositionedPlayer);
    }
}
