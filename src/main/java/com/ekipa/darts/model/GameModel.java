package com.ekipa.darts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author urandumani
 *
 */
public class GameModel {

    private Long gameId;
    private String gameMode;
    private List<PlayerModel> playerModels = new ArrayList<PlayerModel>();
    private String gameStatus;

    public GameModel(Long gameId, String gameMode, List<PlayerModel> playerModels, String gameStatus) {
        this.gameId = gameId;
        this.gameMode = gameMode;
        this.playerModels = playerModels;
        this.gameStatus = gameStatus;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
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