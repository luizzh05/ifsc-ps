package org.example.entity;

import org.example.interfaces.Bimestre;
import org.example.interfaces.Semestre;

public class SemestreBase implements Semestre {
    private Bimestre b1;
    private Bimestre b2;

    public SemestreBase(Bimestre b1, Bimestre b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    @Override
    public double media() {
        return (b1.media() + b2.media()) / 2;
    }

}
