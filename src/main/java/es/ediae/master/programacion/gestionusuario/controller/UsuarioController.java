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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.controller.dto.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.controller.dto.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(
    origins = "http://localhost:4200",
    allowedHeaders = "*",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS
    }
)
@Tag(name = "Gestión de Usuarios", description = "Endpoints para el control de acceso y administración de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/login")
    public boolean iniciarSesion(@RequestBody UsuarioPostDTO loginDTO) {
        return usuarioService.iniciarSesion(
            loginDTO.getNickUsuario(),
            loginDTO.getContrasena());
    }

    @GetMapping("/usuarios")
    public List<UsuarioDTO> obtenerUsuarios(@RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return usuarioService.obtenerUsuarios(nickUsuario, nickContrasena)
                .stream()
                .map(UsuarioDTO::fromModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/usuarios/{usuarioId}")
    public UsuarioDTO obtenerUsuario(@PathVariable Integer usuarioId, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return UsuarioDTO.fromModel(
            usuarioService.obtenerUsuario(usuarioId, nickUsuario, nickContrasena));
    }

    @PostMapping("/usuarios")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioModel usuario, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return UsuarioDTO.fromModel(
            usuarioService.crearUsuario(usuario, nickUsuario, nickContrasena));
    }

    @PutMapping("/usuarios/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Integer id, @RequestBody UsuarioModel usuario, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return UsuarioDTO.fromModel(
            usuarioService.actualizarUsuario(id, usuario, nickUsuario, nickContrasena));
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id, @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        usuarioService.eliminarUsuario(id, nickUsuario, nickContrasena);
    }
}