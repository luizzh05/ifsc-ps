package org.example.domain.model;

import org.example.domain.interfaces.Nota;

public class NotaBase implements Nota {
    private final double valor;

    public NotaBase(double valor) {
        this.valor = valor;
    }

    @Override
    public double valor() {
        return this.valor;
    }
}
