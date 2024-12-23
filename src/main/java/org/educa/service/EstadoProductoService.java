package org.educa.service;

import org.educa.dao.EstadoProductoDAO;
import org.educa.dao.impl.EstadoProductoDAOImpl;
import org.educa.entity.EstadoProductoEntity;

public class EstadoProductoService {
    private final EstadoProductoDAO estadoProductoDAO = new EstadoProductoDAOImpl();

    /**
     * Obtiene un estado de producto por su id
     * @param i id del estado de producto
     * @return estado de producto
     */
    public EstadoProductoEntity getEstadoProductoById(int i) {
        return estadoProductoDAO.getEstadoProductoById(i);
    }
}
