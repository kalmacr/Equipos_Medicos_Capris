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
 * @author Fabián Vargas
 */
@Data
@Entity
@Table(name = "Centros")
public class Centro implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCentro;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false)
    private Integer tiempoRespuestaHoras;

    public Centro(String nombre, Integer tiempoRespuestaHoras) {
        this.nombre = nombre;
        this.tiempoRespuestaHoras = tiempoRespuestaHoras;
    }

    
    public Centro() {
    }
    
}
