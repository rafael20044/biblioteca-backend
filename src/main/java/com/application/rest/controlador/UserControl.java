package com.application.rest.controlador;

import com.application.rest.controlador.dto.UserDTO;
import com.application.rest.entidades.User;
import com.application.rest.servicios.IUserServicio;
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
@RequestMapping("/api/user")
public class UserControl {
    
    @Autowired
    private IUserServicio servi;
    
    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody UserDTO userDTO) throws URISyntaxException{
        
        if (userDTO.getCedula() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        User user = User.builder()
                .cedula(userDTO.getCedula())
                .nombre(userDTO.getNombre())
                .carrera(userDTO.getCarrera())
                .correo(userDTO.getCorreo())
                .librosPrestados(userDTO.getLibrosPrestados())
                .puesto(userDTO.getPuesto())
                .rol(userDTO.getRol())
                .semestre(userDTO.getSemestre())
                .telefono(userDTO.getTelefono())
                .build();
        
        servi.guardar(user);
        return ResponseEntity.created(new URI("/api/user/save")).build();
    }
    
    @PutMapping("/update/{cedula}")
    public ResponseEntity<?> actualizar(@RequestBody UserDTO userDto, @PathVariable String cedula){
        Optional<User> userOp = servi.buscar(cedula);
        if (userOp.isPresent()) {
            User user = userOp.get();
            user.setCarrera(userDto.getCarrera());
            user.setCedula(userDto.getCedula());
            user.setCorreo(userDto.getCorreo());
            user.setLibrosPrestados(userDto.getLibrosPrestados());
            user.setNombre(userDto.getNombre());
            user.setPuesto(userDto.getPuesto());
            user.setRol(userDto.getRol());
            user.setSemestre(userDto.getSemestre());
            user.setTelefono(userDto.getTelefono());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> buscarTodos(){
        List<UserDTO> lista = servi.buscarTodos().stream().map(user -> UserDTO.builder()
                .carrera(user.getCarrera())
                .cedula(user.getCedula())
                .correo(user.getCorreo())
                .librosPrestados(user.getLibrosPrestados())
                .nombre(user.getNombre())
                .puesto(user.getPuesto())
                .rol(user.getRol())
                .semestre(user.getSemestre())
                .telefono(user.getTelefono())
                .build()
        ).toList();
        
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/find/{cedula}")
    public ResponseEntity<?> buscar(@PathVariable String cedula){
        Optional<User> userOp = servi.buscar(cedula);
        if (userOp.isPresent()) {
            User user = userOp.get();
            UserDTO userDto = UserDTO.builder()
                    .carrera(user.getCarrera())
                    .cedula(user.getCedula())
                    .correo(user.getCorreo())
                    .librosPrestados(user.getLibrosPrestados())
                    .nombre(user.getNombre())
                    .puesto(user.getPuesto())
                    .rol(user.getRol())
                    .semestre(user.getSemestre())
                    .telefono(user.getTelefono())
                    .build();
            return  ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/delete/{cedula}")
    public ResponseEntity<?> borrar(@PathVariable String cedula){
        if (servi.buscar(cedula).isPresent()) {
            servi.borrar(cedula);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
