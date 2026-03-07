package org.example.entity;

import org.example.interfaces.Arredondador;

public class ArredondadorMedia implements Arredondador {

    @Override
    public double arredondar(double valor) {
        return Math.round(valor * 2) / 2.0;
    }
}
