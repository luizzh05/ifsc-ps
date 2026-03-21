package org.example.domain.model;

import org.example.domain.interfaces.Avaliavel;
import org.example.domain.interfaces.Nota;

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
