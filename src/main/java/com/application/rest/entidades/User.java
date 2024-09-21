package com.application.rest.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    
    @Id
    @Column(name = "cedula")
    private String cedula;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "carrera")
    private String carrera;
    
    @Column(name = "semestre")
    private String semestre;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "librosPrestados")
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Libro> librosPrestados;
    
    @Column(name = "puesto")
    private Puesto puesto;
    
    @Column(name = "rol")
    private String rol;
}
