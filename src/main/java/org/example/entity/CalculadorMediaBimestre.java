package org.example.entity;

import org.example.interfaces.Bimestre;
import org.example.interfaces.CalculadorBimestre;

public class CalculadorMediaBimestre implements CalculadorBimestre {

    @Override
    public double calcular(Bimestre bimestre) {
        int qtdAvaliacoes = bimestre.quantidadeAvaliacoes();

        if (qtdAvaliacoes == 0) {
            return 0;
        }

        double somaNotas = 0;

        for(int i = 0; i < qtdAvaliacoes; i++) {
            somaNotas += bimestre.notaAvaliacao(i);
        }

        return somaNotas / qtdAvaliacoes;
    }
}
