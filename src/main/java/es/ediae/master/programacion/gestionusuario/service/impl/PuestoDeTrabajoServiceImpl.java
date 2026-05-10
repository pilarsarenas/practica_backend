package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.IPuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajoService;
import es.ediae.master.programacion.gestionusuario.service.PuestoDeTrabajoModel;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoDeTrabajoService {

    @Autowired
    private IPuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo(String nickUsuario, String nickContraseña) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContraseña)) {
            return null;
        }
     return puestoDeTrabajoRepository.findAll().stream()
                .map(PuestoDeTrabajoModel::fromEntity)
                .toList();
                }

}
