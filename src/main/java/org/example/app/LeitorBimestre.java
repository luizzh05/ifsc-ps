package org.example.app;

import org.example.domain.model.AvaliacaoBase;
import org.example.domain.model.BimestreBase;
import org.example.domain.model.NotaBase;
import org.example.domain.model.NotaValida;
import org.example.domain.interfaces.*;
import org.example.io.Entrada;
import org.example.io.Saida;

public class LeitorBimestre {
    private final Entrada entrada;
    private final Saida saida;

    public LeitorBimestre(Entrada entrada, Saida saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    public Bimestre ler(int numeroBimestre) {
        Bimestre bimestre = new BimestreBase();

        saida.linha("====================================================");
        saida.linha("Quantas avaliações houve no " + numeroBimestre + " bimestre?");
        saida.linha("====================================================");

        int quantidade = entrada.lerInteiro();

        for(int i = 1; i <= quantidade; i++){
            saida.linha("Digite a nota da " + i + " avaliação do " + numeroBimestre + " bimestre:");
            double nota = entrada.lerDouble();

            Nota notaValida = new NotaValida(new NotaBase(nota));
            Avaliavel avaliacao = new AvaliacaoBase(notaValida);

            bimestre.addAvaliacao(avaliacao);
        }

        return bimestre;
    }
}
