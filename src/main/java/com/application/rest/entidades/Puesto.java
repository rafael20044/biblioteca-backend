package com.application.rest.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    
 
    @OneToMany(mappedBy = "puesto", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> usuariosUsando;
}
