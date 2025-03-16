package com.EquiposMedicos.domain;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "Errores")
public class Errores implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idError")
    private Long idError;

    private String codigoError;
    private String descripcion;
    private Date fechaRegistro;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idPrioridad", referencedColumnName = "idPrioridad")
    private PrioridadError prioridad;
}