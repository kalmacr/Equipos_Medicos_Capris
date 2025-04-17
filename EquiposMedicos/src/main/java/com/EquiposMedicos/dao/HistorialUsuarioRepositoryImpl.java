/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.domain.HistorialUsuario;
import com.EquiposMedicos.service.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Repository
public class HistorialUsuarioRepositoryImpl {

    
    @Autowired
    private UsuariosServices usuariosServices;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public HistorialUsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("historial_usuarios_mgmt") 
                .withFunctionName("get_historial_usuarios")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new EstadoRowMapper());
    }

    private final class EstadoRowMapper implements RowMapper<HistorialUsuario> {
        @Override
        public HistorialUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            HistorialUsuario historial = new HistorialUsuario();
            historial.setIdHistorial(rs.getLong("IDHISTORIAL")); 
            historial.setUsuario(usuariosServices.getUsuarioBYID(rs.getLong("IDUSUARIO"))); 
            LocalDateTime fechaHora = rs.getObject("FECHAHORA", LocalDateTime.class);
            historial.setFechaHora(fechaHora); 
            historial.setAccion(rs.getString("ACCION")); 
            return historial;
        }
    }

    public List<HistorialUsuario> getHistorial() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<HistorialUsuario>) result.get("result");
    }
}