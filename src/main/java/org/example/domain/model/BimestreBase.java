package org.example.domain.model;

import org.example.domain.interfaces.Avaliavel;
import org.example.domain.interfaces.Bimestre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BimestreBase implements Bimestre {
    private final List<Avaliavel> avaliacoes;

    public BimestreBase() {
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public double media() {
        if (this.avaliacoes.isEmpty()) {
            return 0;
        }

        double somaNotas = 0;
        for (Avaliavel avaliacao : this.avaliacoes) {
            somaNotas += avaliacao.nota();
        }
        return somaNotas / this.avaliacoes.size();
    }

    @Override
    public void addAvaliacao(Avaliavel avaliacao) {
        this.avaliacoes.add(Objects.requireNonNull(avaliacao, "avaliacao nao pode ser nula"));
    }

    @Override
    public List<Avaliavel> avaliacoes() {
        return List.copyOf(this.avaliacoes);
    }


}
