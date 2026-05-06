package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IPuestoDeTrabajoService {

    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo();

}
