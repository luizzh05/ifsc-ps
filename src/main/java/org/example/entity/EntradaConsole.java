package org.example.entity;

import org.example.interfaces.Entrada;

import java.util.Scanner;

public class EntradaConsole implements Entrada {
    private final Scanner scanner;

    public EntradaConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public double lerDado() {
        return this.scanner.nextDouble();
    }
}
