package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IPuestoDeTrabajoService {

    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo(String nickUsuario, String nickContrasena);
     public PuestoDeTrabajoModel obtenerPuestoDeTrabajo(Integer id, String nickUsuario, String nickContrasena);
    public PuestoDeTrabajoModel crearPuestoDeTrabajo(PuestoDeTrabajoModel puesto, String nickUsuario, String nickContrasena);
    public PuestoDeTrabajoModel actualizarPuestoDeTrabajo(Integer id, PuestoDeTrabajoModel puesto, String nickUsuario, String nickContrasena);
    public void eliminarPuestoDeTrabajo(Integer id, String nickUsuario, String nickContrasena);

}
