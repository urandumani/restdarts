package com.ekipa.darts.dao.impl;

import org.springframework.stereotype.Repository;

import com.ekipa.darts.dao.PlayerDao;
import com.ekipa.entity.Player;

@Repository
public class PlayerDaoImpl extends BaseDaoImpl<Player>implements PlayerDao {

    public PlayerDaoImpl() {
        clazz = Player.class;
    }
}
