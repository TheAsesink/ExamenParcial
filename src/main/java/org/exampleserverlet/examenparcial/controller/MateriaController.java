package org.exampleserverlet.examenparcial.controller;

import jakarta.validation.Valid;
import org.exampleserverlet.examenparcial.entity.Materia;
import org.exampleserverlet.examenparcial.service.MateriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/materias")
    public String listar(Model model) {
        model.addAttribute("materias", materiaService.listarActivas());
        return "materias";
    }

    @GetMapping("/materias/nueva")
    public String nueva(Model model) {
        model.addAttribute("materia", new Materia());
        return "form-materia";
    }

    @PostMapping("/materias")
    public String guardar(@Valid @ModelAttribute Materia materia,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "form-materia";
        }

        materiaService.guardar(materia);
        return "redirect:/materias";
    }

    @GetMapping("/materias/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("materia", materiaService.buscarPorId(id));
        return "form-materia";
    }

    @PostMapping("/materias/{id}")
    public String actualizar(@PathVariable Long id,
                             @Valid @ModelAttribute Materia materia,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "form-materia";
        }

        Materia existente = materiaService.buscarPorId(id);
        existente.setCodigo(materia.getCodigo());
        existente.setNombre(materia.getNombre());
        existente.setCreditos(materia.getCreditos());
        existente.setSemestre(materia.getSemestre());

        materiaService.guardar(existente);
        return "redirect:/materias";
    }

    @PostMapping("/materias/{id}/eliminar")
    public String eliminar(@PathVariable Long id) {
        materiaService.eliminarLogico(id);
        return "redirect:/materias";
    }
}