package com.ekipa.darts.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ekipa.darts.model.GameModel;
import com.ekipa.darts.model.PlayerModel;
import com.ekipa.entity.Game;
import com.ekipa.entity.Player;

@Component
public class GameParser {

    public GameModel parseGameEntity(Game game) {
        GameModel gameModel = new GameModel();
        gameModel.setGameId(game.getId());
        gameModel.setGameStatus(game.getGameStatus().getValue());
        gameModel.setPlayerModels(parsePlayerEntities(game.getPlayers()));
        return gameModel;
    }

    public List<PlayerModel> parsePlayerEntities(List<Player> players) {
        List<PlayerModel> playerModels = new ArrayList<PlayerModel>();
        for (Player player : players) {
            playerModels.add(parsePlayerEntity(player));
        }
        return playerModels;
    }

    public PlayerModel parsePlayerEntity(Player player) {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setCurrentScore(player.getCurrentScore());
        playerModel.setCurrentThrow(player.getCurrentThrow());
        playerModel.setName(player.getName());
        return playerModel;
    }
}