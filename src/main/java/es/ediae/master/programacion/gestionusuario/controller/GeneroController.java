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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/generos")
@Tag(name = "Géneros", description = "Definición de géneros para los perfiles de usuario")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoService;

    @Operation(summary = "Obtener lista de géneros", description = "Recupera todos los géneros registrados tras validación de administrador.")
    @ApiResponse(responseCode = "200", description = "Lista recuperada con éxito")
    @GetMapping
    public List<GeneroModel> obtenerGeneros(
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {

        return generoService.obtenerGeneros(nickUsuario, nickContrasena);
    }

    @Operation(summary = "Obtener un género por ID")
    @ApiResponse(responseCode = "200", description = "Género encontrado")
    @ApiResponse(responseCode = "404", description = "El ID de género no existe")
    @GetMapping("/{generoId}")
    public GeneroModel obtenerGenero(@PathVariable Integer generoId, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return generoService.obtenerGenero(generoId, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Crear nuevo género", description = "Añade un nuevo género al sistema.")
    @ApiResponse(responseCode = "200", description = "Género creado")
    @PostMapping
    public GeneroModel crearGenero(@RequestBody GeneroModel genero, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return generoService.crearGenero(genero, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Actualizar género", description = "Modifica un género existente.")
    @ApiResponse(responseCode = "200", description = "Género actualizado")
    @PutMapping("/{id}")
    public GeneroModel updateGenero(@PathVariable Integer id, @RequestBody GeneroModel genero,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return generoService.actualizarGenero(id, genero, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Eliminar género", description = "Elimina un género.")
    @ApiResponse(responseCode = "204", description = "Género eliminado correctamente")
    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        generoService.eliminarGenero(id, nickUsuario, nickContrasena);
    }
}
