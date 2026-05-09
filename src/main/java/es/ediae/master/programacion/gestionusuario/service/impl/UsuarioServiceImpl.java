package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.IUsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository UsuarioRepository;

    @Override
    public List<UsuarioModel> obtenerUsuarios() {
        return UsuarioRepository.findAll().stream()
                .map(UsuarioModel::fromEntity)
                .toList();
    }

    @Override
    public UsuarioModel obtenerUsuario(Integer id) {

        return UsuarioRepository.findById(id)
                .map(UsuarioModel::fromEntity)
                .orElse(null);
    }

    @Override
    public UsuarioModel crearUsuario(UsuarioModel usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        if (UsuarioRepository.existsByNickUsuario(usuario.getNickUsuario())) {
        throw new RuntimeException("El nickUsuario ya existe");
    }

        usuarioEntity.setNickUsuario(usuario.getNickUsuario());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuarioEntity.setFechaHoraCreacion(usuario.getFechaHoraCreacion());
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setPrimerApellido(usuario.getPrimerApellido());
        usuarioEntity.setSegundoApellido(usuario.getSegundoApellido());
        usuarioEntity.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioEntity.setHoraDesayuno(usuario.getHoraDesayuno());
        usuarioEntity.setGenero(usuario.getGenero());
        usuarioEntity.setPuestoDeTrabajo(usuario.getPuestoDeTrabajo());
        usuarioEntity.setEsAdmin(usuario.isEsAdmin());

        return UsuarioModel.fromEntity(UsuarioRepository.save(usuarioEntity));

    }

@Override
public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario) {

    Optional<UsuarioEntity> optionalUsuario = UsuarioRepository.findById(id);

    if (optionalUsuario.isPresent()) {

        UsuarioEntity usuarioEntity = optionalUsuario.get();

        Optional<UsuarioEntity> usuarioConMismoNick =
                UsuarioRepository.findByNickUsuario(usuario.getNickUsuario());

        if (usuarioConMismoNick.isPresent()
                && !usuarioConMismoNick.get().getId().equals(id)) {

            throw new RuntimeException("El nickUsuario ya existe");
        }

        usuarioEntity.setNickUsuario(usuario.getNickUsuario());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuarioEntity.setFechaHoraCreacion(usuario.getFechaHoraCreacion());
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setPrimerApellido(usuario.getPrimerApellido());
        usuarioEntity.setSegundoApellido(usuario.getSegundoApellido());
        usuarioEntity.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioEntity.setHoraDesayuno(usuario.getHoraDesayuno());
        usuarioEntity.setGenero(usuario.getGenero());
        usuarioEntity.setPuestoDeTrabajo(usuario.getPuestoDeTrabajo());
        usuarioEntity.setEsAdmin(usuario.isEsAdmin());

        return UsuarioModel.fromEntity(UsuarioRepository.save(usuarioEntity));

    } else {

        return null;
    }
}

    @Override
    public void eliminarUsuario(Integer id) {
        UsuarioRepository.deleteById(id);
    }

    @Override
    public boolean iniciarSesion(String nickUsuario, String contrasena) {
        return UsuarioRepository
                .findByNickUsuarioAndContrasena(nickUsuario, contrasena)
                .isPresent();
    }

}
