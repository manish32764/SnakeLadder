package com.snakeLadder.gameCreate;

import com.snakeLadder.dice.Dice;
import com.snakeLadder.play.Game;
import com.snakeLadder.players.Player;
import com.snakeLadder.structure.Board;

import java.util.ArrayList;
import java.util.List;

public class NewGameCreator {

    private final NewBoardCreator newBoardCreator = new NewBoardCreator();

    public Game newGame(List<String> playerNames){
        List<Player> players = new ArrayList<>();
        for(String playerName: playerNames){
            Player player = new Player(playerName);
            players.add(player);
        }
        Board board = newBoardCreator.newBoard();
        return new Game(board, new Dice(), players);
    }
}
