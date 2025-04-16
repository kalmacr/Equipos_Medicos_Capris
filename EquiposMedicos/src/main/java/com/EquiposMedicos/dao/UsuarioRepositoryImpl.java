/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;


import com.EquiposMedicos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Repository
public class UsuarioRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public UsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("usuarios_mgmt") 
                .withFunctionName("get_usuarios")
                .declareParameters(
                        new SqlParameter("p_Estado", Types.NUMERIC),
                        new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new UsuarioRowMapper());
    }

    private static final class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getLong("idUsuario")); 
            usuario.setNombre(rs.getString("nombre")); 
            usuario.setCorreo(rs.getString("correo")); 
            usuario.setRol(rs.getString("rol")); 
            return usuario;
        }
    }

    public List<Usuario> getUsuario(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("p_Estado", id);

    Map<String, Object> result = simpleJdbcCall.execute(params);
    return (List<Usuario>) result.get("result");
    }
}