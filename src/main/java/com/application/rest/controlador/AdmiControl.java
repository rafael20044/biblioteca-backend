package com.application.rest.controlador;

import com.application.rest.controlador.dto.AdmiDTO;
import com.application.rest.entidades.Admi;
import com.application.rest.servicios.IAdmiServicio;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
