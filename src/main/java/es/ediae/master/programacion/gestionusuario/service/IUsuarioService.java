package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


public interface IUsuarioService {

    public List<UsuarioModel> obtenerUsuarios();
    public UsuarioModel obtenerUsuario(Integer id);
    public UsuarioModel crearUsuario(UsuarioModel usuario);
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario);
    public void eliminarUsuario(Integer id);
    public boolean iniciarSesion(String nickUsuario, String contrasena);
}
