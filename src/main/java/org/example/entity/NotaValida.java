package org.example.entity;

import org.example.interfaces.Nota;

public class NotaValida implements Nota {
    private final Nota nota;

    public NotaValida(Nota nota) {
        if (nota.valor() < 0 || nota.valor() > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        this.nota = nota;
    }


    @Override
    public double valor() {
        return this.nota.valor();
    }
}
