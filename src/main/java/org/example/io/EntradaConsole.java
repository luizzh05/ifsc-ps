package org.example.io;

import java.util.Scanner;

public class EntradaConsole implements Entrada {
    private final Scanner scanner;

    public EntradaConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int lerInteiro() {
        return this.scanner.nextInt();
    }

    @Override
    public double lerDouble() {
        return this.scanner.nextDouble();
    }
}
