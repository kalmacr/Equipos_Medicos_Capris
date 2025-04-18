
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.ErroresPorCategoria;
import java.sql.Date;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kcalm
 */
public interface ErroresPorCategoriaDao extends JpaRepository<ErroresPorCategoria, Long> {
       @Procedure(name = "insertar_error_categoria", procedureName = "errores_categoria_mgmt.insertar_error_categoria")
    void insertarErrroresCate(
        @Param("p_idCategoria") Long idCategoria,
        @Param("p_idError") Long idError,
        @Param("p_fechaRegistro") LocalDateTime fechaRegistro

    );
    
    @Procedure(name = "eliminar_error_categoria", procedureName = "errores_categoria_mgmt.eliminar_error_categoria")
    void eliminarErrroresPorCate(@Param("p_idErrorCategoria") Long idErrorCategoria);
    
    @Procedure(name = "update_error_categoria", procedureName = "errores_categoria_mgmt.update_error_categoria")
    void actualizarErrroesPorca(
        @Param("p_idErrorCategoria") Long idErrorCategoria,
        @Param("p_idCategoria") Long idCategoria,
        @Param("p_idError") Long idError,
        @Param("p_fechaRegistro") LocalDateTime fechaRegistro
    );
    
}
