package org.example.domain.service;

import org.example.domain.interfaces.Arredondador;

public class ArredondadorPadrao implements Arredondador {

    @Override
    public double arredondar(double valor) {
        return Math.round(valor * 2) / 2.0;
    }
}
