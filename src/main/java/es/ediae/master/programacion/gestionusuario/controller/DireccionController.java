package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

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

import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/direcciones")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Direcciones", description = "API para la gestión de las direcciones de los usuarios")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionService;

    @Operation(summary = "Listar direcciones de un usuario", description = "Obtiene todas las direcciones asociadas a un ID de usuario tras validar credenciales.")
    @ApiResponse(responseCode = "200", description = "Lista de direcciones obtenida con éxito")
    @GetMapping("/usuario/{usuarioId}")
    public List<DireccionModel> obtenerDirecciones(@PathVariable Integer usuarioId, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return direccionService.obtenerDirecciones(usuarioId, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Obtener una dirección específica", description = "Recupera los detalles de una dirección por su ID.")
    @ApiResponse(responseCode = "200", description = "Dirección encontrada")
    @ApiResponse(responseCode = "404", description = "Dirección no encontrada")
    @GetMapping("/{id}")
    public DireccionModel obtenerDireccion(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return direccionService.obtenerDireccion(id, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Crear nueva dirección", description = "Registra una nueva dirección en el sistema para un usuario.")
    @ApiResponse(responseCode = "200", description = "Dirección creada correctamente")
    @PostMapping
    public DireccionModel crearDireccion(@RequestBody DireccionModel direccion, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return direccionService.crearDireccion(direccion, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Actualizar dirección existente", description = "Modifica los datos de una dirección ya registrada.")
    @ApiResponse(responseCode = "200", description = "Dirección actualizada correctamente")

    @PutMapping("/{id}")
    public DireccionModel actualizarDireccion(@PathVariable Integer id, @RequestBody DireccionModel direccion,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return direccionService.actualizarDireccion(id, direccion, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Eliminar dirección", description = "Borra permanentemente una dirección del sistema.")
    @ApiResponse(responseCode = "200", description = "Dirección eliminada con éxito")

    @DeleteMapping("/{id}")
    public void eliminarDireccion(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        direccionService.eliminarDireccion(id, nickUsuario, nickContrasena);
    }
}