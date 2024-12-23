package org.educa.dao;

import org.educa.entity.PedidoEntity;

public interface PedidoDAO {
    /**
     * metodo para insertar un pedido
     * @param pedido pedido a insertar
     */
    void insertarPedido(PedidoEntity pedido);
}
