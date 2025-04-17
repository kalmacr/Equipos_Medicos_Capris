/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Errores;
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
public class ErroresRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public ErroresRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("errores_mgmt") 
                .withFunctionName("get_errores")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new ErroresRowMapper());
    }

    private static final class ErroresRowMapper implements RowMapper<Errores> {
        @Override
        public Errores mapRow(ResultSet rs, int rowNum) throws SQLException {
            Errores errores = new Errores();
            errores.setIdError(rs.getLong("idError")); 
            errores.setCodigoError(rs.getString("codigoError")); 
            errores.setDescripcion(rs.getString("descripcion")); 
            errores.setFechaRegistro(rs.getDate("fechaRegistro")); 
            errores.setTipo(rs.getString("tipo"));
            return errores;
        }
    }

    public List<Errores> getErrores() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Errores>) result.get("result");
    }
}