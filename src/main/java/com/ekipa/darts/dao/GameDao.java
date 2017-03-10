package com.ekipa.darts.dao;

import com.ekipa.entity.Game;

public interface GameDao extends BaseDao<Game> {

    void deleteAllGames();
}