package org.example.entity;

import org.example.interfaces.CalculadorSemestre;
import org.example.interfaces.Semestre;

public class CalculadorMediaSemestre implements CalculadorSemestre {

    @Override
    public double calcular(Semestre semestre) {
        int qtdBimestres = semestre.quantidadeBimestre();

        if (qtdBimestres < 1) {
            return 0;
        }

        double soma = 0;

        for(int i = 0; i < qtdBimestres; i++) {
            soma += semestre.mediaBimestre(i);
        }

        return soma / qtdBimestres;

    }
}
