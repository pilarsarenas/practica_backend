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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.service.GeneroModel;
import es.ediae.master.programacion.gestionusuario.service.impl.GeneroServiceImpl;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoService;

    @GetMapping
    public List<GeneroModel> obtenerGeneros(
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        return generoService.obtenerGeneros(nickUsuario, nickContrasena);
    }

    @GetMapping("/{generoId}")
    public GeneroModel obtenerGenero(@PathVariable Integer generoId, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return generoService.obtenerGenero(generoId, nickUsuario, nickContrasena);
    }

    @PostMapping
    public GeneroModel crearGenero(@RequestBody GeneroModel genero, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return generoService.crearGenero(genero, nickUsuario, nickContrasena);
    }

    @PutMapping("/{id}")
    public GeneroModel updateGenero(@PathVariable Integer id, @RequestBody GeneroModel genero,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return generoService.actualizarGenero(id, genero, nickUsuario, nickContrasena);
    }

    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        generoService.eliminarGenero(id, nickUsuario, nickContrasena);
    }
}
