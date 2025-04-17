/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
/**
 *
 * @author Chope2805
 */
@Data
@Entity
@Table(name = "Ubicaciones")
public class Ubicacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    @Column(nullable = false, length = 100)
    private String nombre;

 
    private String descripcion;

    @Column(length = 100)
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "idCentro", nullable = false)
    private Centro centro;

    public Ubicacion(String nombre, String descripcion, String responsable, Centro centro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.centro = centro;
    }
    public Ubicacion() {
    }
    
}