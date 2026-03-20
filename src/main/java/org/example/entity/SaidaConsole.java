package org.example.entity;

import org.example.interfaces.Saida;

public class SaidaConsole implements Saida {
    @Override
    public void linha(String mensagem) {
        System.out.println(mensagem);
    }
}
