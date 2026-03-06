package org.example.entity;

import org.example.interfaces.Nota;

public class NotaValidada implements Nota {
    private Nota nota;

    public NotaValidada(Nota nota) {
        if (nota.valor() < 0 || nota.valor() > 10) {
            throw new IllegalArgumentException("Valor da nota deve ser entre 0 e 10.");
        }
        this.nota = nota;
    }

    @Override
    public double valor() {
        return nota.valor();
    }
}
