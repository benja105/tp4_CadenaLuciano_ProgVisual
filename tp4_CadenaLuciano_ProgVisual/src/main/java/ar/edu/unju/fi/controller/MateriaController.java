package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaCollection materiaCollection;

    @GetMapping
    public String listarMaterias(Model model) {
        model.addAttribute("materias", materiaCollection.listar());
        return "materias";
    }

    @GetMapping("/nueva")
    public String nuevaMateria(Model model) {
        model.addAttribute("materia", new Materia());
        return "nuevaMateria";
    }

    @PostMapping
    public String agregarMateria(@ModelAttribute Materia materia) {
        materiaCollection.agregar(materia);
        return "redirect:/materias";
    }

    @GetMapping("/editar/{codigo}")
    public String editarMateria(@PathVariable String codigo, Model model) {
        Materia materia = materiaCollection.buscar(codigo);
        model.addAttribute("materia", materia);
        return "editarMateria";
    }

    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute Materia materia) {
        materiaCollection.modificar(materia);
        return "redirect:/materias";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable String codigo) {
        materiaCollection.eliminar(codigo);
        return "redirect:/materias";
    }
}
