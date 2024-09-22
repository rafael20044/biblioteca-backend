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
@Table(name = "admi")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Admi {
    @Id
    @Column(name = "cedula")
    private String cedula;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "contraseña")
    private String contraseña;
    
}
