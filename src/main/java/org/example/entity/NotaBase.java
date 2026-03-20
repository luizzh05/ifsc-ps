package org.example.entity;

import org.example.interfaces.Nota;

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
