package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IGeneroService {

    public List<GeneroModel> obtenerGeneros(String nickUsuario, String nickContraseña);

}
