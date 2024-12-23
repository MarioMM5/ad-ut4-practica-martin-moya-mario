package org.educa.service;

import org.educa.dao.ClienteDAO;
import org.educa.dao.impl.ClienteDAOImpl;
import org.educa.entity.ClienteEntity;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();

    /**
     * Realiza el login de un cliente
     * @param dni dni del cliente
     * @param password password del cliente
     * @return cliente logueado
     */
    public ClienteEntity login(String dni, String password) {
        return clienteDAO.login(dni, password);
    }
}
