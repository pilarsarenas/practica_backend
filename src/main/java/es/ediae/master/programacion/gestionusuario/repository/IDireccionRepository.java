package es.ediae.master.programacion.gestionusuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;



@Repository
public interface IDireccionRepository extends JpaRepository<DireccionEntity, Integer> {

    @Query("SELECT d FROM DireccionEntity d WHERE d.usuario.id = :usuarioId")
    List<DireccionEntity> buscarPorUsuarioId(Integer usuarioId);

    List<DireccionEntity> findByUsuarioIdAndDireccionPrincipalTrue(Integer usuarioId);
}