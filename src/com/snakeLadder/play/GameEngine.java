package com.snakeLadder.play;

import com.snakeLadder.dice.Dice;
import com.snakeLadder.dice.DiceState;
import com.snakeLadder.log.LogPrinter;
import com.snakeLadder.players.Player;
import com.snakeLadder.rules.ExtraTurnRule;
import com.snakeLadder.rules.ForwardMoveCalculator;
import com.snakeLadder.structure.Board;
import com.snakeLadder.structure.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameEngine {

    private final ExtraTurnRule extraTurnRule = new ExtraTurnRule();
    private final ForwardMoveCalculator forwardMoveCalculator = new ForwardMoveCalculator();

    public GameResult playGame(Game game){
        GameResult gameResult = new GameResult();

        List<Player> allPlayers = game.getPlayers();
        Dice dice = game.getDice();
        Board board = game.getBoard();

        List<Player> remainingPlayers = findRemainingPlayers(allPlayers);
        while(remainingPlayers.size() != 1){
            for(int i=0; i<remainingPlayers.size(); ++i){
                Player currentPlayer = remainingPlayers.get(i);
                play(currentPlayer, dice, board);
                gameResult.addPlayerOnCompletion(currentPlayer);
            }
            remainingPlayers = findRemainingPlayers(allPlayers);
        }
        return gameResult;
    }

    private void play(Player currentPlayer, Dice dice, Board board) {
        boolean extraTurnAllowed = false;
        do{
            DiceState diceState = currentPlayer.rollDice(dice);
            Optional<Square> newSquare = forwardMoveCalculator.getNewPosition(currentPlayer, diceState, board, false);
            LogPrinter.printMoveInformation(currentPlayer, diceState, newSquare);
            extraTurnAllowed = extraTurnRule.isEligible(currentPlayer, dice.getCurrentState(), board);
            board.movePlayerAt(currentPlayer, newSquare);
            //sleep(2);
        }while(extraTurnAllowed);
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<Player> findRemainingPlayers(List<Player> allPlayers) {
        List<Player> remainingPlayers = new ArrayList<>();
        for(Player currentPlayer : allPlayers){
            if(!currentPlayer.getCurrentPosition().isPresent() || currentPlayer.getCurrentPosition().get().getDisplayNumber() < 100) {
                remainingPlayers.add(currentPlayer);
            }
        }
        return remainingPlayers;
    }
}
