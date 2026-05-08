package com.evaluacionhito3.structures;

import com.evaluacionhito3.models.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class ListaEstudiantes {
    private Nodo cabeza;

    public void insertar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null)
                actual = actual.getSiguiente();
            actual.setSiguiente(nuevo);
        }
    }

    public List<Estudiante> mostrarEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.getEstudiante());
            actual = actual.getSiguiente();
        }
        return lista;
    }

    public Estudiante buscarPorNombre(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getEstudiante().getNombre().equalsIgnoreCase(nombre))
                return actual.getEstudiante();
            actual = actual.getSiguiente();
        }
        return null;
    }

    public List<Estudiante> ordenarAprobadosMayorAMenor() {
        List<Estudiante> aprobados = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            Estudiante e = actual.getEstudiante();
            if (e.getPuntaje() >= 60)
                aprobados.add(e);
            actual = actual.getSiguiente();
        }

        for (int i = 0; i < aprobados.size() - 1; i++) {
            for (int j = 0; j < aprobados.size() - i - 1; j++) {
                if (aprobados.get(j).getPuntaje() < aprobados.get(j + 1).getPuntaje()) {
                    Estudiante temp = aprobados.get(j);
                    aprobados.set(j, aprobados.get(j + 1));
                    aprobados.set(j + 1, temp);
                }
            }
        }
        return aprobados;
    }
}