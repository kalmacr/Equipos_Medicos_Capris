/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
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
public class CategoriaEquipoRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public CategoriaEquipoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("categoria_equipo_mgmt") 
                .withFunctionName("get_categorias_equipos")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new EstadoRowMapper());
    }

    private static final class EstadoRowMapper implements RowMapper<CategoriaEquipo> {
        @Override
        public CategoriaEquipo mapRow(ResultSet rs, int rowNum) throws SQLException {
            CategoriaEquipo categoriaEquipo = new CategoriaEquipo();
            categoriaEquipo.setIdCategoria(rs.getLong("IDCATEGORIA")); 
            categoriaEquipo.setNombreCategoria(rs.getString("NOMBRECATEGORIA")); 
            return categoriaEquipo;
        }
    }

    public List<CategoriaEquipo> getCategoriaEquipos() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<CategoriaEquipo>) result.get("result");
    }
}