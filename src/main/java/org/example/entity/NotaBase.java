package org.example.entity;

import org.example.interfaces.Nota;

public class NotaBase implements Nota {
    private double valor;

    public NotaBase(double valor) {
        this.valor = valor;
    }

    @Override
    public double valor() {
        return valor;
    }
}
