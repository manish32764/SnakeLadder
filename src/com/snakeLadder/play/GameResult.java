package com.snakeLadder.play;

import com.snakeLadder.players.Player;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<Player> ranking = new ArrayList<>();

    public void addPlayer(Player player){
        ranking.add(player);
    }

    public List<Player> getRanking() {
        return new ArrayList<>(ranking);
    }

    public void addPlayerOnCompletion(Player currentPlayer) {
        if(currentPlayer.getCurrentPosition().isPresent() && currentPlayer.getCurrentPosition().get().getDisplayNumber() == 100){
            ranking.add(currentPlayer);
        }
    }
}
