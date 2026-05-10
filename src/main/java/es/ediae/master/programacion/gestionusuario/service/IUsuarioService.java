package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;


public interface IUsuarioService {

    public List<UsuarioModel> obtenerUsuarios(String nickUsuario, String nickContrasena);
    public UsuarioModel obtenerUsuario(Integer id, String nickUsuario, String nickContrasena);
    public UsuarioModel crearUsuario(UsuarioModel usuario, String nickUsuario, String nickContrasena);
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario, String nickUsuario, String nickContrasena);
    public void eliminarUsuario(Integer id, String nickUsuario, String nickContrasena);
    public boolean iniciarSesion(String nickUsuario, String contrasena);
}
