package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.repository.IDireccionRepository;
import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;

@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private IDireccionRepository DireccionRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Override
    public List<DireccionModel> obtenerDirecciones(Integer usuarioId, String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
        return DireccionRepository.buscarPorUsuarioId(usuarioId).stream()
                .map(DireccionModel::fromEntity)
                .toList();
    }

    @Override
    public DireccionModel obtenerDireccion(Integer id, String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
        return DireccionRepository.findById(id)
                .map(DireccionModel::fromEntity)
                .orElse(null);
    }

private void validarDireccionPrincipalUnica(DireccionModel direccion, Integer direccionExistenteId) {
        if (Boolean.TRUE.equals(direccion.getDireccionPrincipal()) && direccion.getUsuario() != null && direccion.getUsuario().getId() != null) {
            List<DireccionEntity> direccionesPrincipales = DireccionRepository
                    .findByUsuarioIdAndDireccionPrincipalTrue(direccion.getUsuario().getId());

            if (!direccionesPrincipales.isEmpty()) {
                if (direccionExistenteId == null || direccionesPrincipales.stream()
                        .anyMatch(d -> !d.getId().equals(direccionExistenteId))) {
                    throw new RuntimeException("Ya existe una dirección principal para este usuario");
                }
            }
        }
    }

    @Override
    public DireccionModel crearDireccion(DireccionModel direccion, String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }

        validarDireccionPrincipalUnica(direccion, null);

        DireccionEntity direccionEntity = new DireccionEntity();

        direccionEntity.setNombreCalle(direccion.getNombreCalle());
        direccionEntity.setNumeroCalle(direccion.getNumeroCalle());
        direccionEntity.setDireccionPrincipal(direccion.getDireccionPrincipal());
        direccionEntity.setUsuario(direccion.getUsuario());

        return DireccionModel.fromEntity(DireccionRepository.save(direccionEntity));

    }

    @Override
    public DireccionModel actualizarDireccion(Integer id, DireccionModel direccion, String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return null;
        }
        Optional<DireccionEntity> optionalDireccion = DireccionRepository.findById(id);

        if (optionalDireccion.isPresent()) {
            validarDireccionPrincipalUnica(direccion, id);

            DireccionEntity direccionEntity = optionalDireccion.get();

            direccionEntity.setNombreCalle(direccion.getNombreCalle());
            direccionEntity.setNumeroCalle(direccion.getNumeroCalle());
            direccionEntity.setDireccionPrincipal(direccion.getDireccionPrincipal());
            direccionEntity.setUsuario(direccion.getUsuario());

            return DireccionModel.fromEntity(DireccionRepository.save(direccionEntity));
        } else {
            return null;
        }
    }

    @Override
    public void eliminarDireccion(Integer id, String nickUsuario, String nickContrasena) {
        if (!usuarioService.iniciarSesion(nickUsuario, nickContrasena)) {
            return;
        }
        DireccionRepository.deleteById(id);
    }

   
}
