package com.application.rest.implemet;

import com.application.rest.entidades.User;
import com.application.rest.persisten.IUserPer;
import com.application.rest.repositorio.UserRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public class UserImp implements IUserPer{
    
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
