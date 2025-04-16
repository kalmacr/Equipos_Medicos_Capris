/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Fabián Vargas
 */
public interface UsuariosDao extends JpaRepository<Usuario,Long> {
    
    @Procedure(name = "insertar_usuario", procedureName = "usuarios_mgmt.insertar_usuario")
    void insertarEstado(
        @Param("p_nombre") String nombre,
        @Param("p_correo") String correo,
        @Param("p_rol") String rol,
        @Param("p_contraseña") String contrasena
        
    );
    
    @Procedure(name = "update_usuario", procedureName = "usuarios_mgmt.eliminar_usuario")
    void eliminarEstado(@Param("p_idUsuario") Long idUsuario);
    
    @Procedure(name = "actualizarEstado", procedureName = "usuarios_mgmt.update_usuario")
    void actualizarEstado(
        @Param("p_idUsuario") Long idUsuario,
        @Param("p_nombre") String nombre,
        @Param("p_correo") String correo,
        @Param("p_rol") String rol,
        @Param("p_contraseña") String contrasena
    );
    
    
}
