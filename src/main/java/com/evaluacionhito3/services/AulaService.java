package com.evaluacionhito3.services;

import org.springframework.stereotype.Service;

@Service
public class AulaService {
    private int[][] asientos = new int[5][5];

    public String ocuparAsiento(int fila, int columna) {
        if (fila < 1 || fila > 5 || columna < 1 || columna > 5) {
            return "Fila o columna inválida";
        }
        if (asientos[fila-1][columna-1] == 0) {
            asientos[fila-1][columna-1] = 1;
            return "Asiento ocupado";
        }
        return "Asiento ya ocupado";
    }

    public String liberarAsiento(int fila, int columna) {
        if (fila < 1 || fila > 5 || columna < 1 || columna > 5) {
            return "Fila o columna inválida";
        }
        if (asientos[fila-1][columna-1] == 1) {
            asientos[fila-1][columna-1] = 0;
            return "Asiento liberado";
        }
        return "Asiento ya libre";
    }

    public int[][] mostrarMatriz() {
        return asientos;
    }

    public int contarOcupados() {
        int ocupados = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (asientos[i][j] == 1) ocupados++;
        return ocupados;
    }
}