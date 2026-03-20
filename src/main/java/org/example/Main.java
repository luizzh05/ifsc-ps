package org.example;

import org.example.entity.*;
import org.example.interfaces.*;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new EntradaConsole();
        Saida saida = new SaidaConsole();

        CalcularNotasApp app = new CalcularNotasApp(entrada, saida);
        app.executar();

    }
}