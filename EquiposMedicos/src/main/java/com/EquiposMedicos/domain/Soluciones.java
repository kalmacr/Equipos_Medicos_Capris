/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.domain;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "Soluciones")
public class Soluciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSolucion")
    private Long idSolucion;

    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaImplementacion;

    @ManyToOne
    @JoinColumn(name = "idError", referencedColumnName = "idError")
    private Errores error;

    public Soluciones(String descripcion, Date fechaImplementacion, Errores error) {
        this.descripcion = descripcion;
        this.fechaImplementacion = fechaImplementacion;
        this.error = error;
    }

    public Soluciones() {
    }
    
}
