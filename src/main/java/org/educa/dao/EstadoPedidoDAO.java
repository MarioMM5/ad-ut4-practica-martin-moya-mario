package org.educa.dao;

import org.educa.entity.EstadoPedidoEntity;

public interface EstadoPedidoDAO {
    /**
     * metodo para obtener un estado de pedido por su id
     * @param i id del estado de pedido
     * @return EstadoPedidoEntity
     */
    EstadoPedidoEntity getEstadoPedidoById(int i);
}
