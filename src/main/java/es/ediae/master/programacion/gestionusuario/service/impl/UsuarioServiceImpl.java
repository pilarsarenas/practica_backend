package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.IUsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import es.ediae.master.programacion.gestionusuario.service.LoginService;
import es.ediae.master.programacion.gestionusuario.service.UsuarioModel;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository UsuarioRepository;

    @Autowired
    private LoginService loginService;

    @Override
    public List<UsuarioModel> obtenerUsuarios(String nickUsuario, String nickContrasena) {
         loginService.verificar(nickUsuario, nickContrasena);
        return UsuarioRepository.findAll().stream()
                .map(UsuarioModel::fromEntity)
                .toList();
    }

    @Override
    public UsuarioModel obtenerUsuario(Integer id, String nickUsuario, String nickContrasena) {
         loginService.verificar(nickUsuario, nickContrasena);
        return UsuarioRepository.findById(id)
                .map(UsuarioModel::fromEntity)
                .orElse(null);
    }

    @Override
    public UsuarioModel crearUsuario(UsuarioModel usuario, String nickUsuario, String nickContrasena) {
         loginService.verificar(nickUsuario, nickContrasena);
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        if (UsuarioRepository.existsByNickUsuarioIgnoreCase(usuario.getNickUsuario())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nickUsuario ya existe");
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
public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario, String nickUsuario, String nickContrasena) {
    loginService.verificar(nickUsuario, nickContrasena);
    Optional<UsuarioEntity> optionalUsuario = UsuarioRepository.findById(id);

    if (optionalUsuario.isPresent()) {

        UsuarioEntity usuarioEntity = optionalUsuario.get();

        UsuarioEntity usuarioConMismoNick = UsuarioRepository
                .findByNickUsuarioIgnoreCase(usuario.getNickUsuario())
                .orElse(null);

        if (usuarioConMismoNick != null
                && !usuarioConMismoNick.getId().equals(id)) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nickUsuario ya existe");
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
    public void eliminarUsuario(Integer id, String nickUsuario, String nickContrasena) {
        loginService.verificar(nickUsuario, nickContrasena);
        UsuarioRepository.deleteById(id);
    }

    @Override
    public boolean iniciarSesion(String nickUsuario, String contrasena) {
        return UsuarioRepository
                .findByNickUsuarioAndContrasena(nickUsuario, contrasena)
                .isPresent();
    }

}
