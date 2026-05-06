package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IDireccionService {

    public List<DireccionModel> obtenerDirecciones(Integer usuarioId);
    public DireccionModel obtenerDireccion(Integer id);
    public DireccionModel crearDireccion(DireccionModel direccion);
    public DireccionModel actualizarDireccion(Integer id, DireccionModel direccion);
    public void eliminarDireccion(Integer id);
}