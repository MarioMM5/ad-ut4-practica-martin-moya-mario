package org.educa.dao.impl;

import org.educa.dao.EstadoPedidoDAO;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.EstadoPedidoEntity;
import org.hibernate.Session;

public class EstadoPedidoDAOImpl implements EstadoPedidoDAO {
    @Override
    public EstadoPedidoEntity getEstadoPedidoById(int i) {
        try (Session session = DAOSession.getSession()) {
            return session.get(EstadoPedidoEntity.class, i);
        }
    }
}
