/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Centro;
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
public class CentrosRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public CentrosRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("centros_mgmt") 
                .withFunctionName("get_centros")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new CentroRowMapper());
    }

    private static final class CentroRowMapper implements RowMapper<Centro> {
        @Override
        public Centro mapRow(ResultSet rs, int rowNum) throws SQLException {
            Centro centro = new Centro();
            centro.setIdCentro(rs.getLong("idCentro")); 
            centro.setNombre(rs.getString("nombre")); 
            centro.setTiempoRespuestaHoras(rs.getInt("tiempoRespuestaHoras")); 
            return centro;
        }
    }

    public List<Centro> getCentro() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Centro>) result.get("result");
    }
}