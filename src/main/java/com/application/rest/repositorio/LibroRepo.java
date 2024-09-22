package com.application.rest.repositorio;

import com.application.rest.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface LibroRepo extends JpaRepository<Libro, String>{
}
