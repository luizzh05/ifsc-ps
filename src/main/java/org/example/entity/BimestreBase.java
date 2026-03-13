package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;
import org.example.interfaces.CalculadorBimestre;

import java.util.ArrayList;
import java.util.List;

public class BimestreBase implements Bimestre {
    private final List<Avaliavel> avaliacoes;
    private final CalculadorBimestre calculador;

    public BimestreBase() {
        this(new CalculadorMediaBimestre());
    }

    public BimestreBase(CalculadorBimestre calculador) {
        this.avaliacoes = new ArrayList<>();
        this.calculador = calculador;
    }

    @Override
    public double media() {
        return this.calculador.calcular(this);
    }

    @Override
    public void addAvaliacao(Avaliavel avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    @Override
    public int quantidadeAvaliacoes() {
        return this.avaliacoes.size();
    }

    @Override
    public double notaAvaliacao(int indice) {
        return this.avaliacoes.get(indice).nota();
    }


}
