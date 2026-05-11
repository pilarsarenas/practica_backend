package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;
import es.ediae.master.programacion.gestionusuario.repository.IGeneroRepository;
import es.ediae.master.programacion.gestionusuario.service.GeneroModel;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;
import es.ediae.master.programacion.gestionusuario.service.LoginService;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private IGeneroRepository generoRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private LoginService loginService;

    @Override
    public List<GeneroModel> obtenerGeneros(String nickUsuario, String nickContrasena) {
        loginService.verificar(nickUsuario, nickContrasena);

        return generoRepository.findAll().stream()
                .map(GeneroModel::fromEntity)
                .toList();
    }

    @Override
    public GeneroModel obtenerGenero(Integer id, String nickUsuario, String nickContrasena) {
        loginService.verificar(nickUsuario, nickContrasena);
       
        return generoRepository.findById(id)
                .map(GeneroModel::fromEntity)
                .orElse(null);
    }

    @Override
    public GeneroModel crearGenero(GeneroModel genero, String nickUsuario, String nickContrasena) {
        loginService.verificar(nickUsuario, nickContrasena);
      
        GeneroEntity generoEntity = new GeneroEntity();

        if (generoRepository.existsByNombre(genero.getNombre())) {
            throw new RuntimeException("El nombre de género ya existe");
        }

        generoEntity.setNombre(genero.getNombre());
        return GeneroModel.fromEntity(generoRepository.save(generoEntity));
    }

    @Override
    public GeneroModel actualizarGenero(Integer id, GeneroModel genero, String nickUsuario, String nickContrasena) {
        loginService.verificar(nickUsuario, nickContrasena);
       
        Optional<GeneroEntity> optionalGenero = generoRepository.findById(id);

        if (optionalGenero.isPresent()) {

            GeneroEntity generoEntity = optionalGenero.get();

            Optional<GeneroEntity> generoConMismoNombre = generoRepository.findByNombre(genero.getNombre());

            if (generoConMismoNombre.isPresent()
                    && !generoConMismoNombre.get().getId().equals(id)) {

                throw new RuntimeException("El nombre de género ya existe");
            }

            generoEntity.setNombre(genero.getNombre());
            return GeneroModel.fromEntity(generoRepository.save(generoEntity));
        } else {
            return null;
        }
    }

    @Override
    public void eliminarGenero(Integer id, String nickUsuario, String nickContrasena) {
        loginService.verificar(nickUsuario, nickContrasena);
        generoRepository.deleteById(id);
    }

}
