package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;

import java.util.ArrayList;
import java.util.List;

public class BimestreBase implements Bimestre {
    private List<Avaliavel> avaliacoes;

    public BimestreBase() {
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public double media() {
        if (avaliacoes.isEmpty()) {
            throw new IllegalStateException("Nao e possivel calcular media sem avaliacoes.");
        }

        double soma = 0;
        for (Avaliavel avaliacao : avaliacoes) {
            soma += avaliacao.valor();
        }

        return soma / avaliacoes.size();
    }

    @Override
    public void addAvaliacao(Avaliavel avaliacao) {
        this.avaliacoes.add(avaliacao);
    }
}
