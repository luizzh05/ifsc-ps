package org.example;

import org.example.entity.*;
import org.example.interfaces.Arredondador;
import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;
import org.example.interfaces.Semestre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bimestre b1 = new BimestreBase();
        Bimestre b2 = new BimestreBase();
        Arredondador arredondador = new ArredondadorMedia();

        for(int i = 0; i < 2; i++) {
            System.out.println("Digite a nota " + (i + 1) + " do bimestre 1:");
            double nota = scanner.nextDouble();
            Avaliavel n1 = new NotaAvaliacaoValidada(new AvaliacaoBase(nota));
            b1.addAvaliacao(n1);
        }

        for(int i = 0; i < 2; i++) {
            System.out.println("Digite a nota " + (i + 1) + " do bimestre 2:");
            double nota = scanner.nextDouble();

            Avaliavel n1 = new NotaAvaliacaoValidada(new AvaliacaoBase(nota));
            b2.addAvaliacao(n1);
        }

        Semestre s1 = new SemestreBase(b1, b2);

        System.out.println("------------------------------");
        System.out.println("Média do 1 bimestre: " + b1.media());
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("Média do 2 bimestre: " + b2.media());
        System.out.println("------------------------------");
        System.out.println("Média do semestre: " + s1.media());
        System.out.println("------------------------------");
        System.out.println("Média do semestre arredondada: " + arredondador.arredondar(s1.media()));
    }
}