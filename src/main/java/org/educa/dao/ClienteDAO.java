package org.educa.dao;

import org.educa.entity.ClienteEntity;

public interface ClienteDAO {
    /**
     * metodo para loguear un cliente
     * @param dni dni del cliente
     * @param password password del cliente
     * @return ClienteEntity si el cliente existe, null si no existe
     */
    ClienteEntity login(String dni, String password);
}
