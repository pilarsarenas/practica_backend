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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.controller.dto.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/login")
    public boolean iniciarSesion(@RequestBody UsuarioPostDTO loginDTO) {
    return usuarioService.iniciarSesion(
    loginDTO.getNickUsuario(),
    loginDTO.getContrasena());
    }

    @GetMapping
    public List<UsuarioModel> obtenerUsuarios(@RequestParam String nickUsuario, @RequestParam String nickContrasena) {
    return usuarioService.obtenerUsuarios(nickUsuario, nickContrasena);
    }

    @GetMapping("/{usuarioId}")
    public UsuarioModel obtenerUsuario(@PathVariable Integer usuarioId, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
    return usuarioService.obtenerUsuario(usuarioId, nickUsuario, nickContrasena);
    }

    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
    return usuarioService.crearUsuario(usuario, nickUsuario, nickContrasena);
    }

    @PutMapping("/{id}")
    public UsuarioModel updateUsuario(@PathVariable Integer id, @RequestBody
    UsuarioModel usuario, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
    return usuarioService.actualizarUsuario(id, usuario, nickUsuario, nickContrasena);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
    usuarioService.eliminarUsuario(id, nickUsuario, nickContrasena);
    }
}
