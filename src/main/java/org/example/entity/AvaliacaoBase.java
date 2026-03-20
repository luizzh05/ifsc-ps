package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.example.interfaces.Nota;

public class AvaliacaoBase implements Avaliavel {
    private final Nota nota;

    public AvaliacaoBase(Nota nota) {
        this.nota = nota;
    }


    @Override
    public double nota() {
        return this.nota.valor();
    }
}
