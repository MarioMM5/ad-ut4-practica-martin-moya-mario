package org.educa.service;

import org.educa.dao.ProductoDAO;
import org.educa.dao.impl.ProductoDAOImpl;
import org.educa.entity.EstadoProductoEntity;
import org.educa.entity.ProductoEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductoService {
    private final ProductoDAO productoDAO = new ProductoDAOImpl();
    private final EstadoProductoService estadoProductoService = new EstadoProductoService();

    /**
     * metodo para obtener todos los productos no repetidos
     * @return productos lista de productos
     */
    public List<ProductoEntity> findAllProducts(){
        List<ProductoEntity> productos = productoDAO.findAllProducts();
        for (ProductoEntity producto : productos) {
            calcularPrecioFinal(producto);
        }
        return productos;
    }

    /**
     * Calcula el precio final de un producto
     * @param producto producto con el precio aplicado
     */
    private static void calcularPrecioFinal(ProductoEntity producto) {
        if (producto.getDescuento() != null) {
            producto.setPrecioFinal(producto.getPrecio().subtract(producto.getPrecio().multiply(producto.getDescuento().divide(BigDecimal.valueOf(100)))));
            producto.setPrecioFinal(producto.getPrecioFinal().setScale(2, RoundingMode.HALF_UP));
            if (producto.getDescuento().compareTo(BigDecimal.ZERO) == 0) {
                producto.setPrecioFinal(producto.getPrecio().setScale(2, RoundingMode.HALF_UP));
            }
        } else {
            producto.setPrecioFinal(producto.getPrecio().setScale(2, RoundingMode.HALF_UP));
        }
    }

    /**
     * Metodo que busca un unico producto por nombre, talla y color
     * @param nombre nombre del producto
     * @param talla talla del producto
     * @param color color del producto
     * @return producto producto encontrado
     */
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color){
        ProductoEntity producto = productoDAO.getFirstProductoByNameTallaAndColor(nombre, talla, color);
        EstadoProductoEntity estadoProducto = estadoProductoService.getEstadoProductoById(2);
        producto.setEstadoProducto(estadoProducto);
        productoDAO.updateProducto(producto);
        return producto;
    }

    /**
     * Metodo que busca todos los productos distintos por nombre
     * @param producto producto a buscar
     * @return productos lista de productos encontrados
     */
    public List<ProductoEntity> findByName(ProductoEntity producto){
        return productoDAO.findByName(producto);
    }

}