package com.application.rest.implemet;

import com.application.rest.entidades.Puesto;
import com.application.rest.persisten.IPuestoPer;
import com.application.rest.repositorio.PuestoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public class PuestoImp implements IPuestoPer{
    
    @Autowired
    private PuestoRepo repo;

    @Override
    public List<Puesto> buscarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Puesto> buscar(String nombre) {
        return repo.findById(nombre);
    }

    @Override
    public void guardar(Puesto puesto) {
        repo.save(puesto);
    }

    @Override
    public void borrar(String nombre) {
        repo.deleteById(nombre);
    }
}
