package org.educa.dao;

import org.educa.entity.EstadoProductoEntity;

public interface EstadoProductoDAO {
    /**
     * metodo para obtener un estado de producto por su id
     * @param i id del estado de producto
     * @return EstadoProductoEntity
     */
    EstadoProductoEntity getEstadoProductoById(int i);
}
