package es.ediae.master.programacion.gestionusuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajoEntity;

@Repository
public interface IPuestoDeTrabajoRepository extends JpaRepository<PuestoDeTrabajoEntity, Integer> {
     Optional<PuestoDeTrabajoEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
