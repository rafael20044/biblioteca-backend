package com.application.rest.implemet;

import com.application.rest.entidades.Libro;
import com.application.rest.persisten.ILibroPer;
import com.application.rest.repositorio.LibroRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public class LibroImp implements ILibroPer{
    
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
