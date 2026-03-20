package org.example.entity;

import org.example.interfaces.Recuperacao;

public class RecuperacaoBase implements Recuperacao {

    @Override
    public boolean elegivel(double frequenciaPercentual, double mediaSemestral) {
        return frequenciaPercentual >= 75 && mediaSemestral < 6 && mediaSemestral >= 4;
    }

    @Override
    public boolean calcularMediaFinal(double n1, double n2, double notaRecuperacao) {
        double Nmaior = Math.max(n1, n2);
        return (Nmaior + notaRecuperacao) / 2 > 6;
    }
}

