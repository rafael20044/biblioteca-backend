package com.application.rest.implemet;

import com.application.rest.entidades.Admi;
import com.application.rest.persisten.IAdmiPer;
import com.application.rest.repositorio.AdmiRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public class AdmiImp implements IAdmiPer{
    
    @Autowired
    private AdmiRepo repo;

    @Override
    public List<Admi> buscarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Admi> buscar(String cedula) {
        return repo.findById(cedula);
    }

    @Override
    public void guardar(Admi admi) {
        repo.save(admi);
    }

    @Override
    public void borrar(String cedula) {
        repo.deleteById(cedula);
    }
}
