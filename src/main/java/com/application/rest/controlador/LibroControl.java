package com.application.rest.controlador;

import com.application.rest.controlador.dto.LibroDTO;
import com.application.rest.entidades.Libro;
import com.application.rest.servicios.ILibroServicio;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Barragán Acevedo
 */

@RestController
@RequestMapping("/api/libro")
@CrossOrigin(origins = "http://localhost:4321")
public class LibroControl {

    @Autowired
    private ILibroServicio servi;

    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody LibroDTO libroDto) throws URISyntaxException {
        if (libroDto.getTitulo() == null) {
            return ResponseEntity.badRequest().build();
        }
        Libro libro = Libro.builder()
                .autor(libroDto.getAutor())
                .cantidadActual(libroDto.getUnidades())
                .categoria(libroDto.getCategoria())
                .descripcion(libroDto.getDescripcion())
                .idioma(libroDto.getIdioma())
                .bytesImagen(libroDto.getBytesImagen())
                .prestados(libroDto.getPrestados())
                .titulo(libroDto.getTitulo())
                .unidades(libroDto.getUnidades())
                .build();
        servi.guardar(libro);
        return ResponseEntity.created(new URI("/api/libro/save")).build();
    }

    @PutMapping("/update/{titulo}")
    public ResponseEntity<?> actualizar(@RequestBody LibroDTO libroDto, @PathVariable String titulo) {
        Optional<Libro> libroOp = servi.buscar(titulo);
        if (libroOp.isPresent()) {
            Libro libro = libroOp.get();
            libro.setAutor(libroDto.getAutor());
            libro.setCantidadActual(libroDto.getCantidadActual());
            libro.setCategoria(libroDto.getCategoria());
            libro.setDescripcion(libroDto.getDescripcion());
            libro.setIdioma(libroDto.getIdioma());
            libro.setBytesImagen(libroDto.getBytesImagen());
            libro.setPrestados(libroDto.getPrestados());
            libro.setTitulo(libroDto.getTitulo());
            libro.setUnidades(libroDto.getUnidades());
            servi.buscar(titulo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> buscarTodos() {
        List<LibroDTO> libros = servi.buscarTodos().stream().map(libro -> LibroDTO.builder()
                .autor(libro.getAutor())
                .cantidadActual(libro.getCantidadActual())
                .categoria(libro.getCategoria())
                .descripcion(libro.getDescripcion())
                .idioma(libro.getIdioma())
                .bytesImagen(libro.getBytesImagen())
                .prestados(libro.getPrestados())
                .titulo(libro.getTitulo())
                .unidades(libro.getUnidades())
                .build()
        ).toList();
        return ResponseEntity.ok(libros);
    }
    
    @GetMapping("/find/{titulo}")
    public ResponseEntity<?> buscar(@PathVariable String titulo){
        Optional<Libro> libroOp = servi.buscar(titulo);
        if (libroOp.isPresent()) {
            Libro libro = libroOp.get();
            LibroDTO libroDto = LibroDTO.builder()
                 .autor(libro.getAutor())
                .cantidadActual(libro.getCantidadActual())
                .categoria(libro.getCategoria())
                .descripcion(libro.getDescripcion())
                .idioma(libro.getIdioma())
                .bytesImagen(libro.getBytesImagen())
                .prestados(libro.getPrestados())
                .titulo(libro.getTitulo())
                .unidades(libro.getUnidades())
                .build();
            return ResponseEntity.ok(libroDto);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{titulo}")
    public ResponseEntity<?> eliminar(@PathVariable String titulo){
        servi.borrar(titulo);
        return ResponseEntity.ok().build();
    }
}
