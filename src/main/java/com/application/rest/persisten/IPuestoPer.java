package com.application.rest.persisten;

import com.application.rest.entidades.Puesto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IPuestoPer {
    
    public List<Puesto> buscarTodos();
    
    public Optional<Puesto> buscar(String nombre);
    
    public void guardar(Puesto puesto);
    
    public void borrar(String nombre);
    
}
