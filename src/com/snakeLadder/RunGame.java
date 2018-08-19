package com.snakeLadder;

import com.snakeLadder.gameCreate.NewGameCreator;
import com.snakeLadder.play.Game;
import com.snakeLadder.play.GameEngine;
import com.snakeLadder.play.GameResult;

import java.util.*;

public class RunGame {

    public static void main(String[] args) {
        Thread.currentThread().setName("manish");
        NewGameCreator gameCreator = new NewGameCreator();
        Game newGame = gameCreator.newGame(Arrays.asList("Manish", "Manisha"));
        GameResult gameResult = new GameEngine().playGame(newGame);
    }

}
