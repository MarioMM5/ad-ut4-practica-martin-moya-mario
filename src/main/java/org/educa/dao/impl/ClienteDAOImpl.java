package org.educa.dao.impl;

import org.educa.dao.ClienteDAO;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ClienteEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public ClienteEntity login(String dni, String pass) {
        try (Session session = DAOSession.getSession()) {
            ClienteEntity cliente = session.createQuery("from ClienteEntity where dni = :dni and pass = :pass", ClienteEntity.class)
                    .setParameter("dni", dni)
                    .setParameter("pass", pass)
                    .uniqueResult();

            if(cliente != null) {
                Hibernate.initialize(cliente.getDirecciones());
                return cliente;
            }else{
                return null;
            }

        }
    }
}
