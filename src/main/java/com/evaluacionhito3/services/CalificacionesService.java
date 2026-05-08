package com.evaluacionhito3.services;

import org.springframework.stereotype.Service;

@Service
public class CalificacionesService {
    private int[] calificaciones = new int[10];
    private int contador = 0;

    public String agregarCalificacion(int valor) {
        if (contador < 10) {
            calificaciones[contador] = valor;
            contador++;
            return "Calificación " + valor + " agregada";
        }
        return "No hay espacio, ya hay 10 calificaciones";
    }

    public int[] mostrarTodas() {
        return calificaciones;
    }

    public double calcularPromedio() {
        if (contador == 0) return 0;
        int suma = 0;
        for (int i = 0; i < contador; i++) {
            suma += calificaciones[i];
        }
        return (double) suma / contador;
    }

    public int obtenerNotaMayor() {
        if (contador == 0) return -1;
        int mayor = calificaciones[0];
        for (int i = 1; i < contador; i++) {
            if (calificaciones[i] > mayor) mayor = calificaciones[i];
        }
        return mayor;
    }

    public int obtenerNotaMenor() {
        if (contador == 0) return -1;
        int menor = calificaciones[0];
        for (int i = 1; i < contador; i++) {
            if (calificaciones[i] < menor) menor = calificaciones[i];
        }
        return menor;
    }
}