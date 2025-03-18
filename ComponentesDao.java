/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;
import com.EquiposMedicos.domain.Componentes;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Chope2805
 */
public interface ComponentesDao extends JpaRepository<Componentes, Long> {
}

