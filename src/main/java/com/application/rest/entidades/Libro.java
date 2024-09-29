package com.application.rest.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "libro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Libro {
     @Id
    @Column(name = "titulo")
    private String titulo;
     
    @Column(name = "autor")
    private String autor;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "idioma")
    private String idioma;
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @Lob
    @Column(name = "imagen")
    private byte bytesImagen[];
    
    @Column(name = "unidades")
    private Integer unidades;
    
    @Column(name = "prestados")
    private Integer prestados;
    
    @Column(name = "cantidadActual")
    private Integer cantidadActual;
}
