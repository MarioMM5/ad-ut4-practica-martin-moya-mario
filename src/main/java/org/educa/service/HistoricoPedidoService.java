package org.educa.service;

import org.educa.dao.HistoricoPedidoDAO;
import org.educa.dao.impl.HistoricoPedidoDAOImpl;
import org.educa.entity.HistoricoPedidoEntity;

public class HistoricoPedidoService {
    private final HistoricoPedidoDAO historicoPedidoDAO = new HistoricoPedidoDAOImpl();

    /**
     *  Inserta un historico de pedido
     * @param historicoPedido historico de pedido a insertar
     */
    public void insertarHistoricoPedido(HistoricoPedidoEntity historicoPedido) {
        historicoPedidoDAO.insertarHistoricoPedido(historicoPedido);
    }
}
