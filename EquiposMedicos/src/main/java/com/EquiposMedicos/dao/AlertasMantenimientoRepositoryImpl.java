/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.AlertaMantenimiento;
import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Componentes;
import com.EquiposMedicos.domain.Equipo;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.domain.Ubicacion;
import com.EquiposMedicos.service.EquiposService;
import com.EquiposMedicos.service.EstadoService;
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
import org.w3c.dom.css.RGBColor;

@Repository
public class AlertasMantenimientoRepositoryImpl {

    
    @Autowired
    private EquiposService equiposService;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public AlertasMantenimientoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("alertas_mantenimiento_mgmt")
                .withFunctionName("get_alertas_mantenimiento")
                .declareParameters(new SqlOutParameter("result", oracle.jdbc.OracleTypes.CURSOR, "SYS_REFCURSOR"))
                .returningResultSet("result", new AlertasRowMapper());
    }

    private final class AlertasRowMapper implements RowMapper<AlertaMantenimiento> {

        @Override
        public AlertaMantenimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
            AlertaMantenimiento alertaMantenimiento = new AlertaMantenimiento();
            alertaMantenimiento.setIdAlerta(rs.getLong("idAlerta"));
            alertaMantenimiento.setEquipo(equiposService.encontrarEquiposbyId(rs.getLong("IDEQUIPO")));
            alertaMantenimiento.setFechaAlerta(rs.getDate("FECHAALERTA"));
            alertaMantenimiento.setMotivo(rs.getString("Motivo"));
            alertaMantenimiento.setEstado(estadoService.encontrarEstadosbyId(rs.getLong("IDESTADO")));
           
            return alertaMantenimiento;
        }
    }

    public List<AlertaMantenimiento> getAlertas() {
        Map<String, Object> result = simpleJdbcCall.execute();
        return (List<AlertaMantenimiento>) result.get("result");
    }
}
