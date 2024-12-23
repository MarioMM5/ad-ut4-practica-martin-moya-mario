package org.educa.dao;

import org.educa.entity.ProductoEntity;

import java.util.List;

public interface ProductoDAO {
    /**
     * metodo para obtener todos los productos no repetidos
     * @return ProductoEntity si existe
     */
    List<ProductoEntity> findAllProducts();

    /**
     * metodo para obtener un unico producto por su talla, color y nombre
     * @param nombre nombre del producto
     * @param talla talla del producto
     * @param color color del producto
     * @return ProductoEntity
     */
    ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color);

    /**
     * metodo para obtener un producto por su nombre
     * @param producto producto a buscar
     * @return Lista de productos con el nombre indicado
     */
    List<ProductoEntity> findByName(ProductoEntity producto);

    /**
     * metodo para insertar un producto
     * @param producto producto a insertar
     */
    void updateProducto(ProductoEntity producto);
}
