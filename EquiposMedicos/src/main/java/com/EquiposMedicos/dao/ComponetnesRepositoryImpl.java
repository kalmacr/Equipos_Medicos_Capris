/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Componentes;
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
public class ComponetnesRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public ComponetnesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("componentes_mgmt")
                .withFunctionName("get_componentes")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new ComponentesRowMapper());
    }

    private static final class ComponentesRowMapper implements RowMapper<Componentes> {

        @Override
        public Componentes mapRow(ResultSet rs, int rowNum) throws SQLException {
            Componentes componentes = new Componentes();
            componentes.setIdComponente(rs.getLong("idComponente"));
            componentes.setNombre(rs.getString("nombre"));
            componentes.setFechaInstalacion(rs.getDate("fechainstalacion"));
            // Equipo (relación ManyToOne)
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(rs.getLong("idequipo"));
            equipo.setNombre(rs.getString("NombreEquipo"));
            componentes.setEquipo(equipo);

        
            return componentes;
        }
    }

    public List<Componentes> getComponentes() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Componentes>) result.get("result");
    }
}
