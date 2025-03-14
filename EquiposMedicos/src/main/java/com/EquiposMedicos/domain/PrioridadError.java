/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.domain;

/**
 *
 * @author Fabián Vargas
 */
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PrioridadesErrores")
public class PrioridadError {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad;
    
    @Column(nullable = false, length = 50)
    private String descripcion;
    
    private Integer tiempoRespuestaEstimada;
    
    
}
