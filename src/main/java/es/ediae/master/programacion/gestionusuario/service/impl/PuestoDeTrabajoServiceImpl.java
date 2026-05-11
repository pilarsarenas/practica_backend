package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;
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
    public List<PuestoDeTrabajoModel> obtenerPuestoDeTrabajo(String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
     return puestoDeTrabajoRepository.findAll().stream()
                .map(PuestoDeTrabajoModel::fromEntity)
                .toList();
                }

    @Override
    public PuestoDeTrabajoModel obtenerPuestoDeTrabajo(Integer id, String nickUsuario, String nickContrasena) {
         if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
        return puestoDeTrabajoRepository.findById(id)
                .map(PuestoDeTrabajoModel::fromEntity)
                .orElse(null);
    }

    @Override
    public PuestoDeTrabajoModel crearPuestoDeTrabajo(PuestoDeTrabajoModel puesto, String nickUsuario,
            String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
        PuestoDeTrabajoEntity puestoDeTrabajoEntity = new PuestoDeTrabajoEntity();

        if (puestoDeTrabajoRepository.existsByNombre(puesto.getNombre())) {
            throw new RuntimeException("El nombre de puesto de trabajo ya existe");
        }

        puestoDeTrabajoEntity.setNombre(puesto.getNombre());
        return PuestoDeTrabajoModel.fromEntity(puestoDeTrabajoRepository.save(puestoDeTrabajoEntity));
    }

    @Override
    public PuestoDeTrabajoModel actualizarPuestoDeTrabajo(Integer id, PuestoDeTrabajoModel puesto, String nickUsuario,
            String nickContrasena) {
         if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
        Optional<PuestoDeTrabajoEntity> optionalPuestoDeTrabajo = puestoDeTrabajoRepository.findById(id);

        if (optionalPuestoDeTrabajo.isPresent()) {

            PuestoDeTrabajoEntity puestoDeTrabajoEntity = optionalPuestoDeTrabajo.get();

            Optional<PuestoDeTrabajoEntity> puestoDeTrabajoConMismoNombre = puestoDeTrabajoRepository.findByNombre(puesto.getNombre());

            if (puestoDeTrabajoConMismoNombre.isPresent()
                    && !puestoDeTrabajoConMismoNombre.get().getId().equals(id)) {

                throw new RuntimeException("El puesto de trabajo ya existe");
            }

            puestoDeTrabajoEntity.setNombre(puesto.getNombre());
            return PuestoDeTrabajoModel.fromEntity(puestoDeTrabajoRepository.save(puestoDeTrabajoEntity));
        } else {
            return null;
        }
    }


    @Override
    public void eliminarPuestoDeTrabajo(Integer id, String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return;
        }
        puestoDeTrabajoRepository.deleteById(id);
    }

}
