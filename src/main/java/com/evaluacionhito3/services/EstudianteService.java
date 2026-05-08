package com.evaluacionhito3.services;

import com.evaluacionhito3.structures.ListaEstudiantes;
import com.evaluacionhito3.models.Estudiante;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    private ListaEstudiantes lista = new ListaEstudiantes();

    public void insertarEstudiante(int id, String nombre, int puntaje) {
        lista.insertar(new Estudiante(id, nombre, puntaje));
    }

    public ListaEstudiantes getLista() {
        return lista;
    }
}