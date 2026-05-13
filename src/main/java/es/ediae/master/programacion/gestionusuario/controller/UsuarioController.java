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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS
})
@Tag(name = "Gestión de Usuarios", description = "Endpoints para el control de acceso y administración de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Operation(summary = "Iniciar sesión", description = "Valida las credenciales de un usuario para permitir el acceso al sistema.")
    @ApiResponse(responseCode = "200", description = "true si las credenciales son válidas, false en caso contrario")
    @PostMapping("/login")
    public boolean iniciarSesion(@RequestBody UsuarioPostDTO loginDTO) {
        return usuarioService.iniciarSesion(
                loginDTO.getNickUsuario(),
                loginDTO.getContrasena());
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Lista todos los perfiles de usuario (requiere credenciales de admin).")
    @GetMapping("/usuarios")
    public List<UsuarioModel> obtenerUsuarios(@RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return usuarioService.obtenerUsuarios(nickUsuario, nickContrasena);
    }

    @Operation(summary = "Obtener usuario por ID", description = "Recupera la información detallada de un usuario específico.")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @GetMapping("/usuarios/{usuarioId}")
    public UsuarioModel obtenerUsuario(@PathVariable Integer usuarioId, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return usuarioService.obtenerUsuario(usuarioId, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Usuario creado con éxito")
    @PostMapping("/usuarios")
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        return usuarioService.crearUsuario(usuario, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Actualizar usuario", description = "Modifica los datos de un usuario existente.")
    @PutMapping("/usuarios/{id}")
    public UsuarioModel updateUsuario(@PathVariable Integer id, @RequestBody UsuarioModel usuario,
            @RequestParam String nickUsuario, @RequestParam String nickContrasena) {
        return usuarioService.actualizarUsuario(id, usuario, nickUsuario, nickContrasena);
    }

    @Operation(summary = "Eliminar usuario", description = "Borra físicamente el registro del usuario del sistema.")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado")
    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String nickContrasena) {
        usuarioService.eliminarUsuario(id, nickUsuario, nickContrasena);
    }
}
