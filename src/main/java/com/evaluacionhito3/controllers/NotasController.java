package com.evaluacionhito3.controllers;

import com.evaluacionhito3.services.CalificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private CalificacionesService service;

    @GetMapping("/agregar")
    public String agregar(@RequestParam int valor) {
        return service.agregarCalificacion(valor);
    }

    @GetMapping
    public int[] listar() {
        return service.mostrarTodas();
    }

    @GetMapping("/promedio")
    public double promedio() {
        return service.calcularPromedio();
    }

    @GetMapping("/max")
    public int max() {
        return service.obtenerNotaMayor();
    }

    @GetMapping("/min")
    public int min() {
        return service.obtenerNotaMenor();
    }
}