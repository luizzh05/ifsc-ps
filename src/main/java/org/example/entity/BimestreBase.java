package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;
import org.example.interfaces.CalculadorBimestre;
import org.example.services.CalculadorMediaBimestre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.avaliacoes.add(Objects.requireNonNull(avaliacao, "avaliacao nao pode ser nula"));
    }

    @Override
    public List<Avaliavel> avaliacoes() {
        return List.copyOf(this.avaliacoes);
    }


}
