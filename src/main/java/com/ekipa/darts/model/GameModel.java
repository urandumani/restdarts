package com.ekipa.darts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author urandumani
 *
 */
public class GameModel {

    private Long gameId;
    private List<PlayerModel> playerModels = new ArrayList<PlayerModel>();
    private String gameStatus;

    public GameModel() {

    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public List<PlayerModel> getPlayerModels() {
        return playerModels;
    }

    public void setPlayerModels(List<PlayerModel> playerModels) {
        this.playerModels = playerModels;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
}