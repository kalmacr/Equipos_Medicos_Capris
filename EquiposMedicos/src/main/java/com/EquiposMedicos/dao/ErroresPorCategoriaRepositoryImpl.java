/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.ErroresPorCategoria;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.service.CategoriaEquipoService;
import com.EquiposMedicos.service.ErroresService;
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
public class ErroresPorCategoriaRepositoryImpl {
    @Autowired
    private CategoriaEquipoService categoriaEquipoService;
    @Autowired
    private ErroresService erroresService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
     @Autowired
    public ErroresPorCategoriaRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("errores_categoria_mgmt") 
                .withFunctionName("get_errores_categoria")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new ErroresCategoriaRowMapper());
    }

    private final class ErroresCategoriaRowMapper implements RowMapper<ErroresPorCategoria> {
        @Override
        public ErroresPorCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
            ErroresPorCategoria erroresCategoria = new ErroresPorCategoria();
            erroresCategoria.setIdErrorCategoria(rs.getLong("IDERRORCATEGORIA")); 
            erroresCategoria.setCategoriaEquipo(categoriaEquipoService.encontrarCategoriabyID(rs.getLong("IDCATEGORIA"))); 
            erroresCategoria.setErrores(erroresService.getErrorByID(rs.getLong("IDERROR"))); 
             LocalDateTime fechaHora = rs.getObject("fechaRegistro", LocalDateTime.class);
            erroresCategoria.setFechaRegistro(fechaHora); 
            return erroresCategoria;
        }
    }

    public List<ErroresPorCategoria> getErroresCateg() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<ErroresPorCategoria>) result.get("result");
    }
}