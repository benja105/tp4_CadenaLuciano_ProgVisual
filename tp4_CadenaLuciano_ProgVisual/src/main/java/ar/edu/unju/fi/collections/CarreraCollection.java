package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Carrera;

@Service
public class CarreraCollection {
    private List<Carrera> carreras = new ArrayList<>();

    public List<Carrera> listar() {
        return carreras;
    }

    public Carrera buscar(String codigo) {
        for (Carrera carrera : carreras) {
            if (carrera.getCodigo().equals(codigo)) {
                return carrera;
            }
        }
        return null;
    }

    public void agregar(Carrera carrera) {
        carreras.add(carrera);
    }

    public void modificar(Carrera carrera) {
        Carrera existente = buscar(carrera.getCodigo());
        if (existente != null) {
            int index = carreras.indexOf(existente);
            carreras.set(index, carrera);
        }
    }

    public void eliminar(String codigo) {
        Carrera carrera = buscar(codigo);
        if (carrera != null) {
            carreras.remove(carrera);
        }
    }
}
