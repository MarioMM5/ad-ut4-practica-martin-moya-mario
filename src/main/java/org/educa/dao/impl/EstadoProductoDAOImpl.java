package org.educa.dao.impl;

import org.educa.dao.EstadoProductoDAO;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.EstadoProductoEntity;
import org.hibernate.Session;

public class EstadoProductoDAOImpl implements EstadoProductoDAO {
    @Override
    public EstadoProductoEntity getEstadoProductoById(int i) {
        try (Session session = DAOSession.getSession()) {
            return session.get(EstadoProductoEntity.class, i);
        }
    }
}
