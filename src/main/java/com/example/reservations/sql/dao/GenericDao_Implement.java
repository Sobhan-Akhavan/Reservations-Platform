package com.example.reservations.sql.dao;

import org.hibernate.Session;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericDao_Implement<entityType, PK extends Serializable> implements GenericDao<entityType, PK> {

    private Class<entityType> entityClass;
    private String className;

    private Session session;
    public void setSession(Session session) {
        this.session = session;
    }

    public GenericDao_Implement() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        entityClass = (Class<entityType>) parameterizedType.getActualTypeArguments()[0];
        String templateName = entityClass.getName();
        this.className = templateName.substring(templateName.indexOf('.') + 1);
    }


    @Override
    public entityType Insert(entityType entity) {
        session.save(entity);
        return entity;
    }

    @Override
    public entityType Update(entityType entity) {
        session.update(entity);
        return entity;
    }

    @Override
    public void Delete(entityType entity) {
        session.delete(entity);
    }

    @Override
    public List<entityType> selectAll() {
        List entities;
        entities = session.createQuery("from  " + className).list();
        return entities;
    }

    @Override
    public entityType getEntity(Serializable id) {
        entityType result = null;
        result = session.get(entityClass, id);
        return result;
    }
}
