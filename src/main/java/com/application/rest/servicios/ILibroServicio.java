package com.application.rest.servicios;

import com.application.rest.entidades.Libro;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface ILibroServicio {
    
     public List<Libro> buscarTodos();
    
    public Optional<Libro> buscar(String titulo);
    
    public void guardar(Libro libro);
    
    public void borrar(String titulo);
    
}
