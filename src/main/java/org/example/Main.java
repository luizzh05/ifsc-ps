package org.example;

import org.example.entity.*;
import org.example.interfaces.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Recuperacao recuperacao = new RecuperacaoBase();

        Bimestre b1 = new BimestreBase();
        Bimestre b2 = new BimestreBase();
        Arredondador arredondador = new ArredondadorPadrao();

        for (int i = 0; i < 2; i++) {
            System.out.println("Digite a nota " + (i + 1) + " do bimestre 1:");
            double nota = scanner.nextDouble();

            Nota n1 = new NotaValida(new NotaBase(nota));

            Avaliavel av1 = new AvaliacaoBase(n1);
            b1.addAvaliacao(av1);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Digite a nota " + (i + 1) + " do bimestre 2:");
            double nota = scanner.nextDouble();

            Nota n2 = new NotaValida(new NotaBase(nota));

            Avaliavel av2 = new AvaliacaoBase(n2);
            b2.addAvaliacao(av2);
        }

        Semestre s1 = new SemestreBase();
        s1.addBimestre(b1);
        s1.addBimestre(b2);

        double n1 = b1.media();
        double n2 = b2.media();
        double mediaSemestral = s1.media();
        double mediaArredondada = arredondador.arredondar(mediaSemestral);

        System.out.println("------------------------------");
        System.out.println("Média do 1 bimestre: " + n1);
        System.out.println("------------------------------");
        System.out.println("Média do 2 bimestre: " + n2);
        System.out.println("------------------------------");
        System.out.println("Média do semestre: " + mediaSemestral);
        System.out.println("------------------------------");
        System.out.println("Média do semestre arredondada: " + mediaArredondada);

        if (arredondador.arredondar(mediaSemestral) < 6) {
            System.out.println("Digite a frequência semestral em percentual (0 a 100):");
            double frequencia = scanner.nextDouble();

            if(!recuperacao.elegivel(frequencia, mediaArredondada)) {
                System.out.println("Aluno sem direito a recuperação.");
            } else {
                System.out.println("Digite a nota da recuperação:");
                double notaRecuperacao = scanner.nextDouble();

                if(recuperacao.calcularMediaFinal(n1, n2, notaRecuperacao) >= 6.0) {
                    System.out.println("Situação final: APROVADO APÓS RECUPERAÇÃO");
                } else {
                    System.out.println("Situação final: REPROVADO APÓS RECUPERAÇÃO");
                }
            }
        }
    }
}