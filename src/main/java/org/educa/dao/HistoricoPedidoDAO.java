package org.educa.dao;

import org.educa.entity.HistoricoPedidoEntity;

public interface HistoricoPedidoDAO {
    /**
     * metodo para insertar un historico de pedido
     * @param historicoPedido historico de pedido a insertar
     */
    void insertarHistoricoPedido(HistoricoPedidoEntity historicoPedido);
}
