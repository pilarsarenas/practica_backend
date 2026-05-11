package es.ediae.master.programacion.gestionusuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByNickUsuarioAndContrasena(String nickUsuario, String contrasena);
    boolean existsByNickUsuario(String nickUsuario);
    Optional<UsuarioEntity> findByNickUsuario(String nickUsuario);
    Optional<UsuarioEntity> findByNickUsuarioIgnoreCase(String nickUsuario);
    boolean existsByNickUsuarioIgnoreCase(String nickUsuario);
}