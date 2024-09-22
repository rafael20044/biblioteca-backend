package com.application.rest.servicios.imp;

import com.application.rest.entidades.User;
import com.application.rest.repositorio.UserRepo;
import com.application.rest.servicios.IUserServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class UserServicio implements IUserServicio{
        
    @Autowired
    private UserRepo repo;

    @Override
    public List<User> buscarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<User> buscar(String cedula) {
        return repo.findById(cedula);
    }

    @Override
    public void guardar(User user) {
        repo.save(user);
    }

    @Override
    public void borrar(String cedula) {
        repo.deleteById(cedula);
    }
}
