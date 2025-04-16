/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;


import com.EquiposMedicos.domain.Centro;
import com.EquiposMedicos.domain.PrioridadError;
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
public class PrioridadErrorRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public PrioridadErrorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("prioridad_error_mgmt") 
                .withFunctionName("get_prioridades_errores")
                .declareParameters(
                        new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new PrioridadErrorRowMapper());
    }

    private static final class PrioridadErrorRowMapper implements RowMapper<PrioridadError> {
        @Override
        public PrioridadError mapRow(ResultSet rs, int rowNum) throws SQLException {
            PrioridadError prioridadError = new PrioridadError();
            prioridadError.setIdPrioridad(rs.getLong("idPrioridad")); 
            prioridadError.setDescripcion(rs.getString("descripcion")); 
            prioridadError.setTiempoRespuestaEstimada(rs.getInt("tiempoRespuestaEstimada")); 
           
            return prioridadError;
        }
    }

    public List<PrioridadError> getPriporidad() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<PrioridadError>) result.get("result");
    }
}