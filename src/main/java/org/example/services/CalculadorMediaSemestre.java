package org.example.services;

import org.example.interfaces.CalculadorSemestre;
import org.example.interfaces.Semestre;

import java.util.List;

public class CalculadorMediaSemestre implements CalculadorSemestre {

    @Override
    public double calcular(Semestre semestre) {
        List<Double> medias = semestre.bimestres().stream()
                .map(bimestre -> bimestre.media())
                .toList();

        int qtdBimestres = medias.size();

        if (qtdBimestres < 1) {
            return 0;
        }

        double soma = 0;

        for (Double mediaBimestre : medias) {
            soma += mediaBimestre;
        }

        return soma / qtdBimestres;

    }
}
