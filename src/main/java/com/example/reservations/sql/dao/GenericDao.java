package com.example.reservations.sql.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <entityType, PK extends Serializable> {
    entityType Insert(entityType entity);
    entityType Update(entityType entity);
    void Delete(entityType entity);
    List<entityType> selectAll();
    entityType getEntity(PK id);
}
