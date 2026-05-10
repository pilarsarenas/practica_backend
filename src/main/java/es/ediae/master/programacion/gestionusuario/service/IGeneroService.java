package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IGeneroService {

    public List<GeneroModel> obtenerGeneros(String nickUsuario, String nickContrasena);
    public GeneroModel obtenerGenero(Integer id, String nickUsuario, String nickContrasena);
    public GeneroModel crearGenero(GeneroModel genero, String nickUsuario, String nickContrasena);
    public GeneroModel actualizarGenero(Integer id, GeneroModel genero, String nickUsuario, String nickContrasena);
    public void eliminarGenero(Integer id, String nickUsuario, String nickContrasena);

}
