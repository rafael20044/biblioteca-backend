package com.application.rest.servicios.imp;

import com.application.rest.entidades.Admi;
import com.application.rest.repositorio.AdmiRepo;
import com.application.rest.servicios.IAdmiServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class AdmiServicio implements IAdmiServicio{
        
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
