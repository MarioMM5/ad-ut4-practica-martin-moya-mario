package org.educa.dao.impl;

import org.educa.dao.ProductoDAO;
import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.EstadoProductoEntity;
import org.educa.entity.ProductoEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public List<ProductoEntity> findAllProducts() {
        try (Session session = DAOSession.getSession()) {
            List<ProductoEntity> productoEntities = session.createQuery("from ProductoEntity p", ProductoEntity.class)
                    .getResultList();

            Set<String> nombres = new HashSet<>();
            List<ProductoEntity> productos = new ArrayList<>();

            for (ProductoEntity producto : productoEntities) {
                if (nombres.add(producto.getNombre())) {
                    Hibernate.initialize(producto.getColeccionBean());
                    productos.add(producto);
                }
            }
            return productos;
        }
    }

    @Override
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color) {
        try (Session session = DAOSession.getSession()) {
            EstadoProductoEntity estadoProducto = new EstadoProductoEntity();
            estadoProducto.setId(1);
            ProductoEntity producto = session.createQuery("from ProductoEntity where nombre = :nombreProducto and talla = :tallaProducto and color = :colorProducto and estadoProducto = :estadoProducto", ProductoEntity.class)
                    .setParameter("nombreProducto", nombre)
                    .setParameter("tallaProducto", talla)
                    .setParameter("colorProducto", color)
                    .setParameter("estadoProducto", estadoProducto)
                    .setReadOnly(true)
                    .stream().findFirst().get();
            Hibernate.initialize(producto.getColeccionBean());
            return producto;
        }
    }

    @Override
    public List<ProductoEntity> findByName(ProductoEntity producto) {
        try (Session session = DAOSession.getSession()) {
            List<ProductoEntity> productoEntities = session.createQuery("from ProductoEntity where nombre = :nombreProducto", ProductoEntity.class)
                    .setParameter("nombreProducto", producto.getNombre())
                    .getResultList();

            Set<String> datos = new HashSet<>();
            List<ProductoEntity> productos = new ArrayList<>();

            for (ProductoEntity product : productoEntities) {
                if (datos.add(product.getTalla())) {
                    Hibernate.initialize(producto.getColeccionBean());
                    productos.add(product);
                }
                if (datos.add(product.getColor())) {
                    Hibernate.initialize(producto.getColeccionBean());
                    productos.add(product);
                }
            }
            productos.removeFirst();
            return productos;
        }
    }

    @Override
    public void updateProducto(ProductoEntity producto) {
        try (Session session = DAOSession.getSession()) {
            session.merge(producto);
            session.getTransaction().commit();
        }
    }
}