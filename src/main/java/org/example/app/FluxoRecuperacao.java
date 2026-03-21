package org.example.app;

import org.example.domain.interfaces.*;
import org.example.io.Entrada;
import org.example.io.Saida;

public class FluxoRecuperacao {
    private final Entrada entrada;
    private final Saida saida;
    private final Recuperacao recuperacao;
    private final Arredondador arredondador;

    public FluxoRecuperacao(Entrada entrada, Saida saida, Recuperacao recuperacao, Arredondador arredondador) {
        this.entrada = entrada;
        this.saida = saida;
        this.recuperacao = recuperacao;
        this.arredondador = arredondador;
    }

    public void executar(Bimestre b1, Bimestre b2, double mediaArredondada){
        saida.linha("ALUNO EM RECUPERAÇÃO");
        saida.linha("Digite a frequência do aluno (em %):");
        double frequencia = entrada.lerDouble();

        if (recuperacao.elegivel(frequencia, mediaArredondada)) {

            saida.linha("Digite a nota de recuperação do aluno: ");
            double notaRecuperacao = entrada.lerDouble();
            double mediaFinal = recuperacao.calcularMediaFinal(b1.media(), b2.media(), notaRecuperacao);

            mediaFinal = arredondador.arredondar(mediaFinal);

            if (mediaFinal >= 6) {
                saida.linha("ALUNO APROVADO NA RECUPERAÇÃO");
            } else {
                saida.linha("ALUNO REPROVADO NA RECUPERAÇÃO");
            }
        } else {
            saida.linha("ALUNO NÃO ELEGÍVEL A RECUPERAÇÃO");
        }
    }
}
