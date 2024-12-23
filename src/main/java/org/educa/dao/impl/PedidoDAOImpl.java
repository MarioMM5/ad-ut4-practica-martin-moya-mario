package org.educa.dao.impl;

import org.educa.dao.PedidoDAO;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.PedidoEntity;
import org.hibernate.Session;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public void insertarPedido(PedidoEntity pedido) {
        try (Session session = DAOSession.getSession()) {
            session.merge(pedido);
            session.getTransaction().commit();
        }
    }
}
