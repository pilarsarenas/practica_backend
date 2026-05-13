package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.service.PuestoDeTrabajoModel;
import es.ediae.master.programacion.gestionusuario.service.impl.PuestoDeTrabajoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/puestosdetrabajo")
@Tag(name = "Puestos de Trabajo", description = "Gestión del catálogo de puestos de trabajo")
public class PuestoDeTrabajoController {

    @Autowired
    private PuestoDeTrabajoServiceImpl puestoDeTrabajoService;

    @Operation(summary = "Listar todos los puestos de trabajo", description = "Retorna el catálogo completo de puestos de trabajo disponibles.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @GetMapping()
    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo(@RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.obtenerPuestoDeTrabajo(nickUsuario, nickContrasena);
    }

    @Operation(summary = "Obtener un puesto de trabajo por su ID", description = "Busca la información detallada de un puesto específico mediante su identificador.")
    @ApiResponse(responseCode = "200", description = "Puesto encontrado")
    @ApiResponse(responseCode = "404", description = "El ID proporcionado no corresponde a ningún puesto")

    @GetMapping("/{puestoDeTrabajoId}")
    public PuestoDeTrabajoModel obtenerPuestoDeTrabajo(@PathVariable Integer puestoDeTrabajoId,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.obtenerPuestoDeTrabajo(puestoDeTrabajoId, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Crear nuevo puesto de trabajo", description = "Registra un nuevo puesto de trabajo en el sistema.")
    @ApiResponse(responseCode = "200", description = "Puesto creado correctamente")
    @PostMapping
    public PuestoDeTrabajoModel crearPuestoDeTrabajo(@RequestBody PuestoDeTrabajoModel puestoDeTrabajo,
            @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.crearPuestoDeTrabajo(puestoDeTrabajo, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Actualizar puesto existente", description = "Modifica los datos de un puesto de trabajo ya registrado.")
    @PutMapping("/{id}")
    public PuestoDeTrabajoModel updatePuestoDeTrabajo(@PathVariable Integer id,
            @RequestBody PuestoDeTrabajoModel puestoDeTrabajo,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.actualizarPuestoDeTrabajo(id, puestoDeTrabajo, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Eliminar un puesto de trabajo", description = "Borra definitivamente un puesto de trabajo del sistema.")
    @ApiResponse(responseCode = "200", description = "Puesto eliminado con éxito")
    @DeleteMapping("/{id}")
    public void eliminarPuestoDeTrabajo(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        puestoDeTrabajoService.eliminarPuestoDeTrabajo(id, nickUsuario, nickContrasena);
    }

}
