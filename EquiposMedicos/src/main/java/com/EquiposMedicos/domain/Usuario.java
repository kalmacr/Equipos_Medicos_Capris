/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.EquiposMedicos.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Fabián Vargas
 */

@Data
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Long idUsuario;
    private String nombre;
    private String correo;
    private String rol;
    @Column(name = "\"contraseña\"")
    private String contrasena; 
    @Column(name="activo")
    private boolean activos;

    public Usuario(String nombre, String correo, String rol, String contraseña, boolean activos) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.contrasena = contraseña;
        this.activos = activos;
    }

    

    public Usuario() {
    }
    
    
    
}
