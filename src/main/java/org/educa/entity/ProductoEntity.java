package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the producto database table.
 */
@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String color;

    private BigDecimal descuento;

    private String nombre;

    private BigDecimal precio;

    @Transient
    private BigDecimal precioFinal;

    private String talla;

    @Column(name = "codigo_barra")
    private String codigoBarra;

    @Column(name = "fec_cre")
    private Timestamp fecCre;

    @Column(name = "fec_mod")
    private Timestamp fecMod;

    @Column(name = "usu_cre")
    private String usuCre;

    @Column(name = "usu_mod")
    private String usuMod;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "coleccion")
    private ColeccionEntity coleccionBean;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "estado")
    private EstadoProductoEntity estadoProducto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo")
    private TipoProductoEntity tipoProducto;

    @ManyToMany(mappedBy = "productos")
    private List<PedidoEntity> pedidos;
}