package org.example.entity;

import org.example.interfaces.Avaliavel;

public class AvaliacaoBase implements Avaliavel {
    private double valor;

    public AvaliacaoBase(double valor) {
        this.valor = valor;
    }


    @Override
    public double nota() {
        return this.valor;
    }
}
