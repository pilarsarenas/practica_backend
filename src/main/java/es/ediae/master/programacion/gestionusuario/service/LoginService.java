package es.ediae.master.programacion.gestionusuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;

@Service
public class LoginService {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    public void verificar(String nickUsuario, String contrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, contrasena)) {
            throw new RuntimeException("Credenciales inválidas: Acceso denegado.");
        }
}

}
