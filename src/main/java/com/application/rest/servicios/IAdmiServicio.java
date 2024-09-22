package com.application.rest.servicios;

import com.application.rest.entidades.Admi;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Barragán Acevedo
 */

public interface IAdmiServicio {

    public List<Admi> buscarTodos();
    
    public Optional<Admi> buscar(String cedula);
    
    public void guardar(Admi admi);
    
    public void borrar(String cedula);    
    
}
