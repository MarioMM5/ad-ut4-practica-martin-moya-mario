package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "direccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String calle;

    private String ciudad;

    private String cp;

    private String pais;

    @Column(name = "fec_cre")
    private Timestamp fecCre;

    @Column(name = "fec_mod")
    private Timestamp fecMod;

    @Column(name = "usu_cre")
    private String usuCre;

    @Column(name = "usu_mod")
    private String usuMod;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity clienteEntity;
}