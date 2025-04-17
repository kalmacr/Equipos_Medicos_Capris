/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.domain.Soluciones;
import com.EquiposMedicos.service.ErroresService;
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
public class SolucionesRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
    
     @Autowired
    private ErroresService  erroresService;
     @Autowired
    public SolucionesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("soluciones_mgmt") 
                .withFunctionName("get_soluciones")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new SolucionRowMapper());
    }

    private final class SolucionRowMapper implements RowMapper<Soluciones> {
        @Override
        public Soluciones mapRow(ResultSet rs, int rowNum) throws SQLException {
            Soluciones solucion = new Soluciones();
            solucion.setIdSolucion(rs.getLong("idSolucion")); 
            solucion.setDescripcion(rs.getString("descripcion")); 
            solucion.setFechaImplementacion(rs.getDate("fechaImplementacion")); 
            
            Errores error = erroresService.getErrorByID(rs.getLong("idError")); 
          
            solucion.setError(error);
            return solucion;
        }
    }

    public List<Soluciones> getSoluciones() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Soluciones>) result.get("result");
    }
}