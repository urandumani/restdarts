package com.ekipa.darts.dao;

import java.util.List;

public interface BaseDao<T> {

    T save(T entity);

    void delete(T entity);

    T find(Long id);

    List<T> findAll();

    Class<T> getClazz();
}