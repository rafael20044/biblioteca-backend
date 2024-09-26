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
public class LibroDTO {

    private String titulo;
     
    private String autor;
    
    private String categoria;
    
    private String idioma;
    
    private String descripcion;
    
    private byte[] imagen;
    
    private Integer unidades;
    
    private Integer prestados;
    
    private Integer cantidadActual;
}
