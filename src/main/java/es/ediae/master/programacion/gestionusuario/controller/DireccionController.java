package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.controller.dto.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/direcciones")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Direcciones", description = "API para la gestión de las direcciones de los usuarios")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionService;

    @GetMapping("/usuario/{usuarioId}")
    public List<DireccionDTO> obtenerDirecciones(@PathVariable Integer usuarioId, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return direccionService.obtenerDirecciones(usuarioId, nickUsuario, nickContrasena)
                .stream()
                .map(DireccionDTO::fromModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DireccionDTO obtenerDireccion(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return DireccionDTO.fromModel(
            direccionService.obtenerDireccion(id, nickUsuario, nickContrasena));
    }

    @PostMapping
    public DireccionDTO crearDireccion(@RequestBody DireccionModel direccion, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return DireccionDTO.fromModel(
            direccionService.crearDireccion(direccion, nickUsuario, nickContrasena));
    }

    @PutMapping("/{id}")
    public DireccionDTO actualizarDireccion(@PathVariable Integer id, @RequestBody DireccionModel direccion,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return DireccionDTO.fromModel(
            direccionService.actualizarDireccion(id, direccion, nickUsuario, nickContrasena));
    }

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        direccionService.eliminarDireccion(id, nickUsuario, nickContrasena);
    }
}