package org.example.entity;

import org.example.interfaces.Arredondador;

public class ArredondadorPadrao implements Arredondador {

    @Override
    public double arredondar(double valor) {
        return Math.round(valor * 2) / 2.0;
    }
}
