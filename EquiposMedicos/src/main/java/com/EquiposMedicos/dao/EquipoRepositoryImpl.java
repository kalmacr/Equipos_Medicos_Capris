/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Equipo;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.domain.Ubicacion;
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
public class EquipoRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public EquipoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("equipos_mgmt")
                .withFunctionName("get_equipos")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new EquiposRowMapper());
    }

    private static final class EquiposRowMapper implements RowMapper<Equipo> {

        @Override
        public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(rs.getLong("idEquipo"));
            equipo.setNombre(rs.getString("nombre"));
            equipo.setTipo(rs.getString("tipo"));
            equipo.setFabricante(rs.getString("fabricante"));
            equipo.setNumeroSerie(rs.getString("idEquipo"));
            // Ubicación (relación ManyToOne)
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setIdUbicacion(rs.getLong("idUbicacion"));
            ubicacion.setNombre(rs.getString("nombreUbicacion"));
            equipo.setUbicacion(ubicacion);

            // Categoría (relación ManyToOne)
            CategoriaEquipo categoria = new CategoriaEquipo();
            categoria.setIdCategoria(rs.getLong("idCategoria"));
            categoria.setNombreCategoria(rs.getString("nombreCategoria"));
            equipo.setCategoriaEquipo(categoria);

            // Estado (relación ManyToOne)
            Estado estado = new Estado();
            estado.setIdEstado(rs.getLong("idEstado"));
            estado.setNombreEstado(rs.getString("nombreEstado")); 
            equipo.setEstado(estado);
            return equipo;
        }
    }

    public List<Equipo> getEquipos() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Equipo>) result.get("result");
    }
}
