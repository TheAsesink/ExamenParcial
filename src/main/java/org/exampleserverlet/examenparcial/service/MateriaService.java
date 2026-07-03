package org.exampleserverlet.examenparcial.service;

import org.exampleserverlet.examenparcial.entity.Materia;
import org.exampleserverlet.examenparcial.repository.MateriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public List<Materia> listarActivas() {
        return materiaRepository.findByActivaTrue();
    }

    public Materia buscarPorId(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Materia no encontrada"));
    }

    public void guardar(Materia materia) {
        materiaRepository.save(materia);
    }

    public void eliminarLogico(Long id) {
        Materia materia = buscarPorId(id);
        materia.setActiva(false);
        materiaRepository.save(materia);
    }

    public boolean existeCodigo(String codigo) {
        return materiaRepository.existsByCodigo(codigo);
    }
}