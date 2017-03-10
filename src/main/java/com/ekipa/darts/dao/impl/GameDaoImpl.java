package com.ekipa.darts.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ekipa.darts.dao.GameDao;
import com.ekipa.entity.Game;

@Repository
public class GameDaoImpl extends BaseDaoImpl<Game>implements GameDao {

    public GameDaoImpl() {
        clazz = Game.class;
    }

    @Override
    public void deleteAllGames() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("deleteAll");
        query.executeUpdate();
    }
}