package org.example.entity;

import org.example.interfaces.Bimestre;
import org.example.interfaces.CalculadorSemestre;
import org.example.interfaces.Semestre;
import org.example.services.CalculadorMediaSemestre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SemestreBase implements Semestre {
    private final List<Bimestre> bimestres;
    private final CalculadorSemestre calculador;

    public SemestreBase() {
        this(new CalculadorMediaSemestre());
    }

    public SemestreBase(CalculadorSemestre calculador) {
        this.bimestres = new ArrayList<>();
        this.calculador = calculador;
    }

    @Override
    public void addBimestre(Bimestre bimestre) {
        this.bimestres.add(Objects.requireNonNull(bimestre, "bimestre nao pode ser nulo"));
    }

    @Override
    public double media() {
        return this.calculador.calcular(this);
    }

    @Override
    public List<Bimestre> bimestres() {
        return List.copyOf(this.bimestres);
    }

}
