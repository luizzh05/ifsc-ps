package org.example.entity;

import org.example.interfaces.Avaliavel;

public class NotaAvaliacaoValidada implements Avaliavel {
    private Avaliavel avaliacao;

    public NotaAvaliacaoValidada(Avaliavel avaliacao) {
        if(avaliacao.nota() < 0 || avaliacao.nota() > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        this.avaliacao = avaliacao;
    }

    @Override
    public double nota() {
        return this.avaliacao.nota();
    }
}
