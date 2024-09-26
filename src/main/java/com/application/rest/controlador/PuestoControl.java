package com.application.rest.controlador;

import com.application.rest.controlador.dto.PuestoDTO;
import com.application.rest.entidades.Puesto;
import com.application.rest.servicios.IPuestoServicio;
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
@RequestMapping("/api/puesto")
public class PuestoControl {
    @Autowired
    private IPuestoServicio servi;
    
    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody PuestoDTO puestoDTO) throws URISyntaxException{
        if (puestoDTO.getNombre() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Puesto puesto = Puesto.builder()
                .espacios(puestoDTO.getEspacios())
                .espaciosActuales(puestoDTO.getEspaciosActuales())
                .nombre(puestoDTO.getNombre())
                .build();
        servi.guardar(puesto);
        return ResponseEntity.created(new URI("/api/puesto/save")).build();
    }
    
    @PutMapping("/update/{nombre}")
    public ResponseEntity<?> actualizar(@RequestBody PuestoDTO puestoDTO, @PathVariable String nombre){
        Optional<Puesto> puestoOp = servi.buscar(nombre);
        if (puestoOp.isPresent()) {
            Puesto puesto = puestoOp.get();
            puesto.setEspacios(puestoDTO.getEspacios());
            puesto.setEspaciosActuales(puestoDTO.getEspaciosActuales());
            puesto.setNombre(puestoDTO.getNombre());
            servi.guardar(puesto);
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> buscarTodos(){
        List<PuestoDTO> puestos = servi.buscarTodos().stream().map(puesto -> PuestoDTO.builder()
                .espacios(puesto.getEspacios())
                .espaciosActuales(puesto.getEspaciosActuales())
                .nombre(puesto.getNombre())
                .build()
        ).toList();
        
        return ResponseEntity.ok(puestos);
    }
    
    @GetMapping("/find/{nombre}")
    public ResponseEntity<?> buscar(@PathVariable String nombre){
        Optional<Puesto> puestoOP = servi.buscar(nombre);
        if (puestoOP.isPresent()) {
            Puesto puesto = puestoOP.get();
            PuestoDTO puestoDto = PuestoDTO.builder()
                    .espacios(puesto.getEspacios())
                    .espaciosActuales(puesto.getEspaciosActuales())
                    .nombre(puesto.getNombre())
                    .build();
            return ResponseEntity.ok(puestoDto);
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{nombre}")
    public ResponseEntity<?> borrar(@PathVariable String nombre){
        servi.borrar(nombre);
        return ResponseEntity.ok().build();
    }
}
