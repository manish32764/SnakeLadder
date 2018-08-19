package com.snakeLadder.structure;

import com.snakeLadder.log.LogPrinter;
import com.snakeLadder.players.Player;

import java.util.Arrays;
import java.util.Optional;

public class Board {
    private final Square[] squares;

    public Board(Square[] squares) {
        this.squares = squares;
    }

    public Square getSquareHavingDisplayNumber(int displayNumber){
        if(displayNumber < 1 || displayNumber > getLastSquareDisplayNumber()){
            throw new IllegalArgumentException("Display Number should be between 1 to " + getLastSquareDisplayNumber() + " Invalid : " + displayNumber);
        }
        return squares[displayNumber - 1];
    }

    public void movePlayerAt(Player player, Optional<Square> newSquare){
        resetCurrentPosition(player);
        player.setCurrentPosition(newSquare);

        if(newSquare.isPresent()) {
            if (newSquare.get().hasPositionedPlayer()) {
                Player playerPreOccupyingPosition = newSquare.get().getCurrentPositionedPlayer().get();
                playerPreOccupyingPosition.setCurrentPosition(Optional.empty());

                LogPrinter.printAttackInformation(player, playerPreOccupyingPosition);
            }
            newSquare.get().setCurrentPositionedPlayer(Optional.of(player));

        }
    }

    private void resetCurrentPosition(Player player) {
        if(player.hasMadeFirstMove()){
            player.getCurrentPosition().get().setCurrentPositionedPlayer(Optional.empty());
        }
    }

    public int getLastSquareDisplayNumber(){
        return squares.length;
    }

    @Override
    public String toString() {
        return "Board{" +
                "squares=" + Arrays.toString(squares) +
                '}';
    }
}
