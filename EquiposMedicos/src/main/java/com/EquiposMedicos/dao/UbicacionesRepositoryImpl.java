/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Centro;
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
public class UbicacionesRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public UbicacionesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("ubicaciones_mgmt")
                .withFunctionName("get_ubicaciones")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new UbicacionRowMapper());
    }

    private static final class UbicacionRowMapper implements RowMapper<Ubicacion> {

        @Override
        public Ubicacion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setIdUbicacion(rs.getLong("idUbicacion"));
            ubicacion.setNombre(rs.getString("nombre"));
            ubicacion.setDescripcion(rs.getString("descripcion"));
            ubicacion.setResponsable(rs.getString("responsable"));
            
            Centro centro = new Centro();
            centro.setIdCentro(rs.getLong("idCentro"));
            centro.setNombre(rs.getString("nombreCentro"));
            ubicacion.setCentro(centro);

            return ubicacion;
        }
    }

    public List<Ubicacion> getUbicaciones() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<Ubicacion>) result.get("result");
    }
}
