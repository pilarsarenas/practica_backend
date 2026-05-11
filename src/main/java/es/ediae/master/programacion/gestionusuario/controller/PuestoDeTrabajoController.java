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

import es.ediae.master.programacion.gestionusuario.service.PuestoDeTrabajoModel;
import es.ediae.master.programacion.gestionusuario.service.impl.PuestoDeTrabajoServiceImpl;


@RestController
@RequestMapping("/api/v1/puestosdetrabajo")
public class PuestoDeTrabajoController {

     @Autowired
    private PuestoDeTrabajoServiceImpl puestoDeTrabajoService;

    @GetMapping()
    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo(@RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.obtenerPuestoDeTrabajo(nickUsuario, nickContrasena);
    }

     @GetMapping("/{puestoDeTrabajoId}")
    public PuestoDeTrabajoModel obtenerPuestoDeTrabajoById(@PathVariable Integer puestoDeTrabajoId, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.obtenerPuestoDeTrabajo(puestoDeTrabajoId, nickUsuario, nickContrasena);
    }

    @PostMapping
    public PuestoDeTrabajoModel crearPuestoDeTrabajo(@RequestBody PuestoDeTrabajoModel puestoDeTrabajo, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.crearPuestoDeTrabajo(puestoDeTrabajo, nickUsuario, nickContrasena);
    }

    @PutMapping("/{id}")
    public PuestoDeTrabajoModel updatePuestoDeTrabajo(@PathVariable Integer id, @RequestBody PuestoDeTrabajoModel puestoDeTrabajo,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return puestoDeTrabajoService.actualizarPuestoDeTrabajo(id, puestoDeTrabajo, nickUsuario, nickContrasena);
    }

    @DeleteMapping("/{id}")
    public void eliminarPuestoDeTrabajo(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        puestoDeTrabajoService.eliminarPuestoDeTrabajo(id, nickUsuario, nickContrasena);
    }

}
