package org.example.entity;

import org.example.interfaces.Arredondador;

public class ArredondadorMedia implements Arredondador {
    private double media;

    public ArredondadorMedia() {
        this.media = media;
    }

    @Override
    public double arredondar(double valor) {
        return Math.round(valor * 2) / 2.0;
    }
}
