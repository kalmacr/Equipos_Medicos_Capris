
package com.EquiposMedicos.service;
import com.EquiposMedicos.domain.Equipos;
import java.util.List;
/**
 *
 * @author Chope2805
 */public interface EquiposService {
    
    List<Equipos> listarEquiposs();
    Equipos encontrarEquipos(Equipos centro);
    void guardar(Equipos centro);
    void eliminar(Equipos centro);
}