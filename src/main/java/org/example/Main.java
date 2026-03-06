package org.example;

import org.example.entity.AvaliacaoBase;
import org.example.entity.BimestreBase;
import org.example.entity.NotaBase;
import org.example.entity.NotaValidada;
import org.example.entity.SemestreBase;
import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;
import org.example.interfaces.Nota;
import org.example.interfaces.Semestre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Nota n1 = new NotaValidada(
                new NotaBase(5.92
                )
        );

        Nota n2 = new NotaValidada(
                new NotaBase(8.49
                )
        );

        Avaliavel av1 = new AvaliacaoBase(n1);
        Avaliavel av2 = new AvaliacaoBase(n2);

        Bimestre b1 = new BimestreBase();
        b1.addAvaliacao(av1);
        b1.addAvaliacao(av2);

        Nota n3 = new NotaValidada(
                new NotaBase(7.8
                )
        );

        Nota n4 = new NotaValidada(
                new NotaBase(6.99
                )
        );

        Bimestre b2 = new BimestreBase();
        b2.addAvaliacao(new AvaliacaoBase(n3));
        b2.addAvaliacao(new AvaliacaoBase(n4));

        Semestre s1 = new SemestreBase(b1, b2);

        System.out.println("Nota 1: " + n1.valor());
        System.out.println("Nota 2: " + n2.valor());
        System.out.println("------------------------------");
        System.out.println("Média do 1 bimestre: " + b1.media());
        System.out.println("------------------------------");
        System.out.println("Nota 3: " + n3.valor());
        System.out.println("Nota 4: " + n4.valor());
        System.out.println("------------------------------");
        System.out.println("Média do 2 bimestre: " + b2.media());
        System.out.println("------------------------------");
        System.out.println("Média do semestre: " + s1.media());
        System.out.println("------------------------------");
        System.out.println("Média do semestre arredondada: " + s1.arredondarMedia());
    }
}