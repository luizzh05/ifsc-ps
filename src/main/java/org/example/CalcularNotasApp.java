package org.example;

import org.example.entity.*;
import org.example.interfaces.*;

public class CalcularNotasApp {
    private final Entrada entrada;
    private final Saida saida;

    public CalcularNotasApp(Entrada entrada, Saida saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    public void executar() {
        Bimestre b1 = new BimestreBase();

        saida.linha("====================================================");
        saida.linha("Quantas avaliações houve no 1 bimestre?");
        saida.linha("====================================================");
        double quantidadeBimestre = entrada.lerDado();

        Bimestre b2 = new BimestreBase();
        saida.linha("====================================================");
        saida.linha("Quantas avaliações houve no 2 bimestre?");
        saida.linha("====================================================");

        double quantidadeBimestre2 = entrada.lerDado();

        for(int i = 0; i < quantidadeBimestre; i++) {
            saida.linha("Digite a nota da " + (i + 1) + " avaliação do primeiro bimestre:");
            double nota = entrada.lerDado();
            Nota n = new NotaValida(
                            new NotaBase(nota)
            );

            Avaliavel av = new AvaliacaoBase(n);

            b1.addAvaliacao(av);
        }

        for(int i = 0; i < quantidadeBimestre2; i++) {
            saida.linha("Digite a nota da " + (i + 1) + " avaliação do segundo bimestre:");
            double nota = entrada.lerDado();
            Nota n = new NotaValida(
                    new NotaBase(nota)
            );

            Avaliavel av = new AvaliacaoBase(n);

            b2.addAvaliacao(av);
        }

        Semestre semestre = new SemestreBase();
        semestre.addBimestre(b1);
        semestre.addBimestre(b2);

        saida.linha("====================================================");
        saida.linha("Média do primeiro bimestre: " + b1.media());
        saida.linha("====================================================");

        saida.linha("====================================================");
        saida.linha("Média do segundo bimestre: " + b2.media());
        saida.linha("====================================================");

        saida.linha("====================================================");
        saida.linha("Média do semestre: " + semestre.media());
        saida.linha("====================================================");

        Arredondador arredondador = new ArredondadorPadrao();
        double mediaArredondada = arredondador.arredondar(semestre.media());
        saida.linha("====================================================");
        saida.linha("Média do semestre arredondada: " + mediaArredondada);
        saida.linha("====================================================");

        if(mediaArredondada < 6 && mediaArredondada >= 4) {
            Recuperacao recuperacao = new RecuperacaoBase();

            saida.linha("====================================================");
            saida.linha("ALUNO EM RECUPERAÇÃO");
            saida.linha("====================================================");

            saida.linha("====================================================");
            saida.linha("Digite a frequência do aluno (em %):");
            saida.linha("====================================================");
            double frequencia = entrada.lerDado();

            saida.linha("====================================================");
            saida.linha("Digite a nota de recuperação do aluno: ");
            saida.linha("====================================================");
            double notaRecuperacao = entrada.lerDado();

            if(recuperacao.elegivel(frequencia, mediaArredondada)) {
                if(recuperacao.calcularMediaFinal(b1.media(), b2.media(), notaRecuperacao)) {
                    saida.linha("====================================================");
                    saida.linha("ALUNO APROVADO NA RECUPERAÇÃO");
                    saida.linha("====================================================");
                } else {
                    saida.linha("====================================================");
                    saida.linha("ALUNO REPROVADO NA RECUPERAÇÃO");
                    saida.linha("====================================================");
                }
            } else {
                saida.linha("====================================================");
                saida.linha("ALUNO NÃO ELEGÍVEL A RECUPERAÇÃO");
                saida.linha("====================================================");
            }
        }
    }
}
