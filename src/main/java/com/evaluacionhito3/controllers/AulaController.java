package com.evaluacionhito3.controllers;

import com.evaluacionhito3.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService service;

    @GetMapping("/ocupar")
    public String ocupar(@RequestParam int fila, @RequestParam int columna) {
        return service.ocuparAsiento(fila, columna);
    }

    @GetMapping("/liberar")
    public String liberar(@RequestParam int fila, @RequestParam int columna) {
        return service.liberarAsiento(fila, columna);
    }

    @GetMapping
    public int[][] mostrar() {
        return service.mostrarMatriz();
    }

    @GetMapping("/ocupados")
    public int ocupados() {
        return service.contarOcupados();
    }
}