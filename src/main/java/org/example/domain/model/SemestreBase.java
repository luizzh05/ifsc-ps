package org.example.domain.model;

import org.example.domain.interfaces.Bimestre;
import org.example.domain.interfaces.Semestre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SemestreBase implements Semestre {
    private final List<Bimestre> bimestres;


    public SemestreBase() {
        this.bimestres = new ArrayList<>();
    }

    @Override
    public void addBimestre(Bimestre bimestre) {
        this.bimestres.add(Objects.requireNonNull(bimestre, "bimestre nao pode ser nulo"));
    }

    @Override
    public double media() {
        if(this.bimestres.isEmpty()) {
            return 0;
        }

        double somaMedia = 0;

        for(Bimestre bimestre : this.bimestres) {
            somaMedia += bimestre.media();
        }
        return somaMedia / this.bimestres.size();
    }

    @Override
    public List<Bimestre> bimestres() {
        return List.copyOf(this.bimestres);
    }

}
