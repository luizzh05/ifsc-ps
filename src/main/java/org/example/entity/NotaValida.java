package org.example.entity;

import org.example.interfaces.Nota;

public class NotaValida implements Nota {
    private final Nota nota;

    public NotaValida(Nota nota) {
        this.nota = nota;
    }


    @Override
    public double valor() {
        double notaRecebida = this.nota.valor();
        if (notaRecebida < 0 || notaRecebida > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }

        return notaRecebida;
    }
}
