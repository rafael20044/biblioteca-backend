package com.application.rest.controlador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PuestoDTO {

    private String nombre;
    
    private Integer espacios;
    
    private Integer espaciosActuales;
    
}
