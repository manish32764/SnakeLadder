package com.snakeLadder.log;

import com.snakeLadder.dice.DiceState;
import com.snakeLadder.players.Player;
import com.snakeLadder.snakeLadder.SnakeOrLadder;
import com.snakeLadder.structure.Square;

import java.util.Optional;

public class LogPrinter {

    private static int i = 1;

    public static void printExtraTurnAllowed(boolean playerAttacked, DiceState diceState, Player currentPlayer, Optional<Square> newSquare){
       if(diceState == DiceState.SIX){
           format(currentPlayer);
             System.out.println("\t WOW Dice State 6 !!!! Got Extra Turn allowed " );
       }else if(playerAttacked){
           format(currentPlayer);
             Optional<Player> anotherPlayer = newSquare.get().getCurrentPositionedPlayer();
             System.out.println("\t Player attached  ******** Extra Turn allowed " + currentPlayer.getName() + " attacked " + anotherPlayer.get().getName() + " at " + newSquare.get().getDisplayNumber());
       }
    }

    public static void printAttackInformation(Player attackingPlayer, Player attackedPlayer) {
        format(attackingPlayer);
        System.out.println(attackingPlayer.getName() + " attacked " + attackedPlayer.getName() + " at " + attackingPlayer.getCurrentPosition().get().getDisplayNumber());
    }

    public static void printMoveInformation(Player currentPlayer, DiceState diceState, Optional<Square> newSquare) {
        int newSquareDisplayNumber = newSquare.isPresent() ? newSquare.get().getDisplayNumber() : -1;
        int currentSquareDisplayNumber = currentPlayer.getCurrentPosition().isPresent() ? currentPlayer.getCurrentPosition().get().getDisplayNumber() : -1;

        format(currentPlayer);
        System.out.print(currentPlayer.getName() +
                " rolled Dice : " + diceState.getNumber() +
                " , {current Position : " + currentSquareDisplayNumber +
                " newPosition : " + newSquareDisplayNumber + " } \n");
    }

    private static void format(Player currentPlayer) {
        if(currentPlayer.getName().equals("Manisha")){
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        }
    }

    public static void printSnakeLadderInformation(Player player, DiceState diceState, Optional<Square> newSquare, SnakeOrLadder snakeOrLadder) {
        format(player);
        int playerCurrentPosition = player.getCurrentPosition().get().getDisplayNumber();
        String playerName = player.getName();
        System.out.println("playerName : " + playerName +
                " currentPosition : " +playerCurrentPosition +
                " diceState : " + diceState.getNumber() +
                " \t new square : " + newSquare.get().getDisplayNumber() +
                snakeOrLadder);
    }
}
