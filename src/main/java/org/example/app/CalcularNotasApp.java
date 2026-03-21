package org.example.app;

import org.example.domain.model.SemestreBase;
import org.example.domain.interfaces.*;
import org.example.io.Saida;

public class CalcularNotasApp {
    private final Saida saida;
    private final LeitorBimestre leitorBimestre;
    private final FluxoRecuperacao fluxoRecuperacao;
    private final Arredondador arredondador;

    public CalcularNotasApp(Saida saida, LeitorBimestre leitorBimestre,
                            FluxoRecuperacao fluxoRecuperacao, Arredondador arredondador) {

        this.saida = saida;
        this.leitorBimestre = leitorBimestre;
        this.fluxoRecuperacao = fluxoRecuperacao;
        this.arredondador = arredondador;
    }

    public void executar() {
        Bimestre b1 = leitorBimestre.ler(1);
        Bimestre b2 = leitorBimestre.ler(2);

        Semestre semestre = new SemestreBase();
        semestre.addBimestre(b1);
        semestre.addBimestre(b2);

        saida.linha("Média do primeiro bimestre: " + b1.media());
        saida.linha("Média do segundo bimestre: " + b2.media());
        saida.linha("Média do semestre: " + semestre.media());

        double mediaArredondada = arredondador.arredondar(semestre.media());
        saida.linha("Média do semestre arredondada: " + mediaArredondada);

        if(mediaArredondada < 6 && mediaArredondada >= 4) {
            fluxoRecuperacao.executar(b1, b2, mediaArredondada);
        }
    }
}
