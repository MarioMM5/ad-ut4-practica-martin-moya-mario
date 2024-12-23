package org.educa.dao.impl;

import org.educa.dao.HistoricoPedidoDAO;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.HistoricoPedidoEntity;
import org.hibernate.Session;

public class HistoricoPedidoDAOImpl implements HistoricoPedidoDAO {
    @Override
    public void insertarHistoricoPedido(HistoricoPedidoEntity historicoPedido) {
        try (Session session = DAOSession.getSession()) {
            session.merge(historicoPedido);
            session.getTransaction().commit();
        }
    }
}
