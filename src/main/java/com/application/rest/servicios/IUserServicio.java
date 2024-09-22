package com.application.rest.servicios;

import com.application.rest.entidades.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IUserServicio {
    
    public List<User> buscarTodos();
    
    public Optional<User> buscar(String cedula);
    
    public void guardar(User user);
    
    public void borrar(String cedula);
    
}
