package com.application.rest.servicios.imp;

import com.application.rest.entidades.Libro;
import com.application.rest.repositorio.LibroRepo;
import com.application.rest.servicios.ILibroServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class LibroServicio implements ILibroServicio{
       
    @Autowired
    private LibroRepo repo;

    @Override
    public List<Libro> buscarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Libro> buscar(String titulo) {
        return repo.findById(titulo);
    }

    @Override
    public void guardar(Libro libro) {
        repo.save(libro);
    }

    @Override
    public void borrar(String titulo) {
        repo.deleteById(titulo);
    }
}
