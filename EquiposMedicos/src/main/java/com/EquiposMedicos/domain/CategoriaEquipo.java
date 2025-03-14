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
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "CategoriasEquipos")
public class CategoriaEquipo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    
    @Column(nullable = false, length = 100)
    private String nombreCategoria;

    public CategoriaEquipo(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaEquipo() {
    }
    
}
