package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionServiceImpl;

@RestController
@RequestMapping("/api/v1/direcciones")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionService;

    @GetMapping("/usuario/{usuarioId}")
    public List<DireccionModel> obtenerDirecciones(@PathVariable Integer usuarioId) {
        return direccionService.obtenerDirecciones(usuarioId);
    }


   @GetMapping("/{id}")
    public DireccionModel obtenerDireccion(@PathVariable Integer id) {
        return direccionService.obtenerDireccion(id);
    }

    @PostMapping("/usuario/{usuarioId}")
    public DireccionModel crearDireccion(@RequestBody DireccionModel direccion) {
        return direccionService.crearDireccion(direccion);
    }

    @PutMapping("/{id}")
    public DireccionModel actualizarDireccion(@PathVariable Integer id, @RequestBody DireccionModel direccion) {
        return direccionService.actualizarDireccion(id, direccion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Integer id) {
        direccionService.eliminarDireccion(id);
    }
}