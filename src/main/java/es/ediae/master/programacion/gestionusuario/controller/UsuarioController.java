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

import es.ediae.master.programacion.gestionusuario.controller.dto.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.service.GeneroModel;
import es.ediae.master.programacion.gestionusuario.service.PuestoDeTrabajoModel;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;
import es.ediae.master.programacion.gestionusuario.service.impl.GeneroServiceImpl;
import es.ediae.master.programacion.gestionusuario.service.impl.PuestoDeTrabajoServiceImpl;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private GeneroServiceImpl generoService;

    @GetMapping("/generos")
    public List<GeneroModel> obtenerGeneros() {
        return generoService.obtenerGeneros();
    }

    @Autowired
    private PuestoDeTrabajoServiceImpl puestoDeTrabajoService;

    @GetMapping("/puestosdetrabajo")
    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo() {
        return puestoDeTrabajoService.obtenerPuestoDeTrabajo();
    }

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/login")
    public boolean iniciarSesion(@RequestBody UsuarioPostDTO loginDTO) {
    return usuarioService.iniciarSesion(
    loginDTO.getNickUsuario(),
    loginDTO.getContrasena());
    }

    @GetMapping
    public List<UsuarioModel> obtenerUsuarios() {
    return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModel obtenerUsuario(@PathVariable Integer usuarioId) {
    return usuarioService.obtenerUsuario(usuarioId);
    }

    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario) {
    return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/{id}")
    public UsuarioModel updateUsuario(@PathVariable Integer id, @RequestBody
    UsuarioModel usuario) {
    return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
    usuarioService.eliminarUsuario(id);
    }
}
