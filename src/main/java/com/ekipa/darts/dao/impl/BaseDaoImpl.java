package com.ekipa.darts.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ekipa.darts.dao.BaseDao;

@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {

    protected Class<T> clazz;

    @Autowired
    @Qualifier("sessionFactory")
    protected SessionFactory sessionFactory;

    @Override
    public Class<T> getClazz() {
        return clazz;
    }

    @Override
    public T save(T entity) {
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public T find(Long id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public List<T> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM ".concat(clazz.getName()));
        List<T> results = query.list();
        return results;
    }

    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}