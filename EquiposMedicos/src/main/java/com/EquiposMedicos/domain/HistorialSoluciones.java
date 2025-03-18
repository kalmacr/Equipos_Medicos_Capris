/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "HistorialSoluciones")
public class HistorialSoluciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHistorialSolucion")
    private Long idHistorialSolucion;

    @ManyToOne
    @JoinColumn(name = "idSolucion", referencedColumnName = "idSolucion")
    private Soluciones solucion;

    private Date fechaAplicacion;

    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "idUsuario")
    private Usuario tecnico;

    private String comentarios;
}
