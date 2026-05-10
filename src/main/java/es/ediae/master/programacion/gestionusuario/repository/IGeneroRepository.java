package es.ediae.master.programacion.gestionusuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.GeneroEntity;


@Repository
public interface IGeneroRepository extends JpaRepository<GeneroEntity, Integer> {
    Optional<GeneroEntity> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
