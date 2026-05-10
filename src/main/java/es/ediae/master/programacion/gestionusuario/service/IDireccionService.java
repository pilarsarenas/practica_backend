package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IDireccionService {

    public List<DireccionModel> obtenerDirecciones(Integer usuarioId, String nickUsuario, String nickContraseña);
    public DireccionModel obtenerDireccion(Integer id, String nickUsuario, String nickContraseña);
    public DireccionModel crearDireccion(DireccionModel direccion, String nickUsuario, String nickContraseña);
    public DireccionModel actualizarDireccion(Integer id, DireccionModel direccion, String nickUsuario, String nickContraseña);
    public void eliminarDireccion(Integer id, String nickUsuario, String nickContraseña);
}