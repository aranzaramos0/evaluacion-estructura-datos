package com.evaluacionhito3.controllers;

import com.evaluacionhito3.models.Estudiante;
import com.evaluacionhito3.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping("/agregar")
    public String agregar(@RequestParam int id, @RequestParam String nombre, @RequestParam int puntaje) {
        service.insertarEstudiante(id, nombre, puntaje);
        return "Estudiante agregado: " + nombre;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.getLista().mostrarEstudiantes();
    }

    @GetMapping("/ordenados")
    public List<Estudiante> ordenados() {
        return service.getLista().ordenarAprobadosMayorAMenor();
    }

    @GetMapping("/buscar/{nombre}")
    public Estudiante buscar(@PathVariable String nombre) {
        Estudiante e = service.getLista().buscarPorNombre(nombre);
        if (e == null) throw new RuntimeException("No encontrado");
        return e;
    }
}