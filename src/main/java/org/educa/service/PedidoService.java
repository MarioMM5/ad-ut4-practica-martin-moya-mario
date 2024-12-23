package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.impl.PedidoDAOImpl;
import org.educa.entity.*;

import java.sql.Timestamp;

public class PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();
    private final HistoricoPedidoService historicoPedidoService = new HistoricoPedidoService();
    private final EstadoPedidoService estadoPedidoService = new EstadoPedidoService();
    private final EstadoProductoService estadoProductoService = new EstadoProductoService();

    /**
     * Inserta un pedido en la base de datos
     * @param pedido pedido a insertar
     */
    public void insertarPedido(PedidoEntity pedido) {
        EstadoProductoEntity estadoProducto = estadoProductoService.getEstadoProductoById(2);
        EstadoPedidoEntity estadoPedido = estadoPedidoService.getEstadoPedidoById(1);
        pedido.setFecha(new Timestamp(System.currentTimeMillis()));
        for(ProductoEntity producto : pedido.getProductos()){
            producto.setEstadoProducto(estadoProducto);
        }
        pedido.setEstadoPedido(estadoPedido);
        HistoricoPedidoEntity historicoPedido = new HistoricoPedidoEntity();
        historicoPedido.setFecMod(new Timestamp(System.currentTimeMillis()));
        historicoPedido.setPedido(pedido);
        historicoPedido.setCambios("Pedido creado");
        historicoPedido.setUsuMod("admin");
        historicoPedidoService.insertarHistoricoPedido(historicoPedido);
        pedidoDAO.insertarPedido(pedido);
    }
}