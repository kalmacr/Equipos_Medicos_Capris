/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Diagnosticos;
import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.service.EquiposService;
import com.EquiposMedicos.service.ErroresService;
import com.EquiposMedicos.service.SolucionesService;
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
public class DiagnosticosRepositoryImpl {

    
    @Autowired
    private EquiposService equipoService;
    @Autowired
    private ErroresService erroresService;
    @Autowired
    private SolucionesService solucionesService;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public DiagnosticosRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("diagnosticos_mgmt") 
                .withFunctionName("get_diagnosticos")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new DiagnosticosRowMapper());
    }

    private final class DiagnosticosRowMapper implements RowMapper<Diagnosticos> {
        @Override
        public Diagnosticos mapRow(ResultSet rs, int rowNum) throws SQLException {
            Diagnosticos diagnosticos = new Diagnosticos();
            diagnosticos.setIdDiagnostico(rs.getLong("idDiagnostico")); 
            diagnosticos.setEquipo(equipoService.encontrarEquiposbyId(rs.getLong("idEquipo"))); 
            diagnosticos.setFecha(rs.getDate("fecha")); 
            diagnosticos.setDescripcionProblema(rs.getString("descripcionProblema")); 
            diagnosticos.setError(erroresService.getErrorByID(rs.getLong("idError")));
            diagnosticos.setSolucion(solucionesService.getSolucionById(rs.getLong("idSolucion")));
            return diagnosticos;
        }
    }

    public List<Diagnosticos> getDiagnosticos() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Diagnosticos>) result.get("result");
    }
}