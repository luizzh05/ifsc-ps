package org.example.app;

import org.example.domain.interfaces.*;
import org.example.io.Entrada;
import org.example.io.EntradaConsole;
import org.example.io.Saida;
import org.example.io.SaidaConsole;
import org.example.domain.service.ArredondadorPadrao;
import org.example.domain.service.RegraRecuperacao;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new EntradaConsole();
        Saida saida = new SaidaConsole();

        Arredondador arredondador = new ArredondadorPadrao();
        Recuperacao recuperacao = new RegraRecuperacao();

        LeitorBimestre leitorBimestre = new LeitorBimestre(entrada, saida);
        FluxoRecuperacao fluxoRecuperacao = new FluxoRecuperacao(entrada, saida, recuperacao, arredondador);

        CalcularNotasApp app = new CalcularNotasApp(saida, leitorBimestre, fluxoRecuperacao, arredondador);
        app.executar();

    }
}