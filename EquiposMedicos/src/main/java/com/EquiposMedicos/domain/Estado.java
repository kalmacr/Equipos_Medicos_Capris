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
@Table(name = "Estado")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;
    
    @Column(nullable = false, length = 50)
    private String nombreEstado;
    
    @Lob
    private String descripcion;
    
    @Column(nullable = false, length = 50)
    private String tipoEstado;

    public Estado(String nombreEstado, String descripcion, String tipoEstado) {
        this.nombreEstado = nombreEstado;
        this.descripcion = descripcion;
        this.tipoEstado = tipoEstado;
    }

    public Estado() {
    }
    
    
    
}
