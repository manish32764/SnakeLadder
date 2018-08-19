package com.snakeLadder.players;

import com.snakeLadder.dice.Dice;
import com.snakeLadder.dice.DiceState;
import com.snakeLadder.structure.Square;

import java.util.Objects;
import java.util.Optional;

public class Player {

    private final String name;
    private Optional<Square> currentPosition;

    public Player(String name) {
        this.name = name;
        currentPosition = Optional.empty();
    }

    public DiceState rollDice(Dice dice){
        return dice.generateNewState();
    }

    public Optional<Square> getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Optional<Square> currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public boolean hasMadeFirstMove(){
        return currentPosition.isPresent();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(currentPosition, player.currentPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currentPosition);
    }
}
