package org.example.entity;

import org.example.interfaces.Bimestre;
import org.example.interfaces.CalculadorSemestre;
import org.example.interfaces.Semestre;

import java.util.ArrayList;
import java.util.List;

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
        this.bimestres.add(bimestre);
    }

    @Override
    public double media() {
        return this.calculador.calcular(this);
    }

    @Override
    public int quantidadeBimestre() {
        return this.bimestres.size();
    }

    @Override
    public double mediaBimestre(int indice) {
        return this.bimestres.get(indice).media();
    }

}
