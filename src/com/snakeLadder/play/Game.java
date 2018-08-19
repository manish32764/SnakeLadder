package com.snakeLadder.play;

import com.snakeLadder.players.Player;
import com.snakeLadder.dice.Dice;
import com.snakeLadder.structure.Board;

import java.util.List;

public class Game {
    private final Board board;
    private final Dice dice;
    private final List<Player> players;

    public Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
