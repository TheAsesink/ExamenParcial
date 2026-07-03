package org.exampleserverlet.examenparcial.repository;

import org.exampleserverlet.examenparcial.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    List<Materia> findByActivaTrue();

    Optional<Materia> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);
}