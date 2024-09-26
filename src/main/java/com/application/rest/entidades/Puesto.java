package com.application.rest.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Entity
@Table(name = "puesto")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Puesto {
    @Id
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "espacios")
    private Integer espacios;
    
    @Column(name = "espaciosActuales")
    private Integer espaciosActuales;
    
}
