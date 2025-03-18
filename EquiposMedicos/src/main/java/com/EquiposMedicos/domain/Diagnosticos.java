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
@Table(name = "Diagnosticos")
public class Diagnosticos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDiagnostico")
    private Long idDiagnostico;

    @ManyToOne
    @JoinColumn(name = "idEquipo", referencedColumnName = "idEquipo")
//    private Equipo equipo;

    private Date fecha;
    private String descripcionProblema;

    @ManyToOne
    @JoinColumn(name = "idError", referencedColumnName = "idError")
    private Error error;

    @ManyToOne
    @JoinColumn(name = "idSolucion", referencedColumnName = "idSolucion")
    private Soluciones solucion;
}
