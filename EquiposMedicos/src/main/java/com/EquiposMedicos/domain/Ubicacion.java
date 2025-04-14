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
@Table(name = "Ubicacions")
public class Ubicacion implements Serializable{
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false)
    private Integer tiempoRespuestaHoras;

    public Ubicacion(String nombre, Integer tiempoRespuestaHoras) {
        this.nombre = nombre;
        this.tiempoRespuestaHoras = tiempoRespuestaHoras;
    }

    
    public Ubicacion() {
    }
    
}