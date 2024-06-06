package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Docente;

@Service
public class DocenteCollection {
    private List<Docente> docentes = new ArrayList<>();

    public List<Docente> listar() {
        return docentes;
    }

    public Docente buscar(String legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo() == legajo) {
                return docente;
            }
        }
        return null;
    }

    public void agregar(Docente docente) {
        docentes.add(docente);
    }

    public void modificar(Docente docente) {
        Docente existente = buscar(docente.getLegajo());
        if (existente != null) {
            int index = docentes.indexOf(existente);
            docentes.set(index, docente);
        }
    }

    public void eliminar(String legajo) {
        Docente docente = buscar(legajo);
        if (docente != null) {
            docentes.remove(docente);
        }
    }
}