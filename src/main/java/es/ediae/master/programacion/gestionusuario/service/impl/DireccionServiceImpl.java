package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.IDireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;

@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private IDireccionRepository DireccionRepository;

    @Override
    public List<DireccionModel> obtenerDirecciones(Integer usuarioId) {
    return DireccionRepository.findById(usuarioId).stream()
            .map(DireccionModel::fromEntity)
            .toList();
}

    @Override
    public DireccionModel obtenerDireccion(Integer id) {

        return DireccionRepository.findById(id)
                .map(DireccionModel::fromEntity)
                .orElse(null);
    }

@Override
public DireccionModel crearDireccion(DireccionModel direccion) {
    
        DireccionEntity direccionEntity = new DireccionEntity();

        direccionEntity.setNombreCalle(direccion.getNombreCalle());
        direccionEntity.setNumeroCalle(direccion.getNumeroCalle());
        direccionEntity.setDireccionPrincipal(direccion.getDireccionPrincipal());
        direccionEntity.setUsuario(direccion.getUsuario());

        return DireccionModel.fromEntity(DireccionRepository.save(direccionEntity));

    }

    @Override
    public DireccionModel actualizarDireccion(Integer id, DireccionModel direccion) {
        Optional<DireccionEntity> optionalDireccion = DireccionRepository.findById(id);

        if (optionalDireccion.isPresent()) {
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
    public void eliminarDireccion(Integer id) {
        DireccionRepository.deleteById(id);
    }

   
}
