package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Materia;

@Service
public class MateriaCollection {
    private List<Materia> materias = new ArrayList<>();

    public List<Materia> listar() {
        return materias;
    }

    public Materia buscar(String codigo) {
        for (Materia materia : materias) {
            if (materia.getCodigo() == codigo) {
                return materia;
            }
        }
        return null;
    }

    public void agregar(Materia materia) {
        materias.add(materia);
    }

    public void modificar(Materia materia) {
        Materia existente = buscar(materia.getCodigo());
        if (existente != null) {
            int index = materias.indexOf(existente);
            materias.set(index, materia);
        }
    }

    public void eliminar(String codigo) {
        Materia materia = buscar(codigo);
        if (materia != null) {
            materias.remove(materia);
        }
    }
}