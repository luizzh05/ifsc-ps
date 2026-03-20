package org.example.services;

import org.example.interfaces.Bimestre;
import org.example.interfaces.CalculadorBimestre;

import java.util.List;

public class CalculadorMediaBimestre implements CalculadorBimestre {

    @Override
    public double calcular(Bimestre bimestre) {
        List<Double> notas = bimestre.avaliacoes().stream()
                .map(avaliacao -> avaliacao.nota())
                .toList();

        int qtdAvaliacoes = notas.size();

        if (qtdAvaliacoes == 0) {
            return 0;
        }

        double somaNotas = 0;

        for (Double nota : notas) {
            somaNotas += nota;
        }

        return somaNotas / qtdAvaliacoes;
    }
}
