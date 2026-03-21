package org.example.io;

public class SaidaConsole implements Saida {
    @Override
    public void linha(String mensagem) {
        System.out.println(mensagem);
    }
}
