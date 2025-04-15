/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Repository
public class EstadoRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public EstadoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("ESTADO_MGMT") 
                .withFunctionName("get_estados")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new EstadoRowMapper());
    }

    private static final class EstadoRowMapper implements RowMapper<Estado> {
        @Override
        public Estado mapRow(ResultSet rs, int rowNum) throws SQLException {
            Estado estado = new Estado();
            estado.setIdEstado(rs.getLong("IDESTADO")); 
            estado.setNombreEstado(rs.getString("NOMBREESTADO")); 
            estado.setDescripcion(rs.getString("DESCRIPCION")); 
            estado.setTipoEstado(rs.getString("TIPOESTADO")); 
            return estado;
        }
    }

    public List<Estado> getEstados() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Estado>) result.get("result");
    }
}