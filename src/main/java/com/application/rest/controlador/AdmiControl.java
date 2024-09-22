package com.application.rest.controlador;

import com.application.rest.controlador.dto.AdmiDTO;
import com.application.rest.entidades.Admi;
import com.application.rest.servicios.IAdmiServicio;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/admi")
public class AdmiControl {
    @Autowired
    private IAdmiServicio repo;
    
    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody AdmiDTO admiDto) throws URISyntaxException{
        if (admiDto.getCedula() == null || admiDto.getNombre() == null) {
            return ResponseEntity.badRequest().build();
        }
        Admi admi = Admi.builder()
                .cedula(admiDto.getCedula())
                .nombre(admiDto.getNombre())
                .contraseña(admiDto.getContraseña())
                .build();
        repo.guardar(admi);
        return ResponseEntity.created(new URI("/api/admi/save")).build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizar(@RequestBody AdmiDTO admidDto,@PathVariable String cedula ){
        Optional<Admi> OpAdmi = repo.buscar(cedula);
        if (OpAdmi.isPresent()) {
            Admi admi = OpAdmi.get();
            admi.setCedula(admidDto.getCedula());
            admi.setNombre(admidDto.getNombre());
            admi.setContraseña(admidDto.getContraseña());
            repo.guardar(admi);
            ResponseEntity.ok();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> buscarTodos(){
        List<AdmiDTO> listaDTO = repo.buscarTodos().stream().map(admi -> AdmiDTO.builder()
                .cedula(admi.getCedula())
                .nombre(admi.getNombre())
                .contraseña(admi.getContraseña())
                .build()
        ).toList();
        return ResponseEntity.ok(listaDTO);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> buscar(@PathVariable String cedula){
        Optional<Admi> Opadmi = repo.buscar(cedula);
        if (Opadmi.isPresent()) {
            Admi admi = Opadmi.get();
            AdmiDTO admiDTO = AdmiDTO.builder()
                    .cedula(admi.getCedula())
                    .nombre(admi.getNombre())
                    .contraseña(admi.getContraseña())
                    .build();
            return ResponseEntity.ok(admiDTO);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrar(@PathVariable String cedula){
        repo.borrar(cedula);
        return ResponseEntity.ok().build();
    }
}
