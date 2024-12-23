package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "coleccion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColeccionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(name = "usu_cre")
    private String usuCre;

    @Column(name = "fec_cre")
    private LocalDate fecCre;

    @Column(name = "usu_mod")
    private String usuMod;

    @Column(name = "fec_mod")
    private LocalDate fecMod;
}