package org.educa.service;

import org.educa.dao.EstadoPedidoDAO;
import org.educa.dao.impl.EstadoPedidoDAOImpl;
import org.educa.entity.EstadoPedidoEntity;

public class EstadoPedidoService {
    private final EstadoPedidoDAO estadoPedidoDAO = new EstadoPedidoDAOImpl();

    /**
     * Obtiene un estado de pedido por su id
     * @param i id del estado de pedido
     * @return estado de pedido
     */
    public EstadoPedidoEntity getEstadoPedidoById(int i) {
        return estadoPedidoDAO.getEstadoPedidoById(i);
    }
}
