package com.application.rest.controlador.dto;

import com.application.rest.entidades.Libro;
import com.application.rest.entidades.Puesto;
import java.util.List;
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
public class UserDTO {

    private String cedula;

    private String nombre;

    private String carrera;

    private String semestre;

    private String correo;

    private String telefono;

    private List<Libro> librosPrestados;

    private Puesto puesto;

    private String rol;
}
