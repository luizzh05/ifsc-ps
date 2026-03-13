package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;
import org.example.interfaces.Semestre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorMediaSemestreTest {

    private Bimestre bimestreComNotas(double... notas) {
        Bimestre b = new BimestreBase();
        for (double nota : notas) {
            Avaliavel av = new NotaAvaliacaoValidada(new AvaliacaoBase(nota));
            b.addAvaliacao(av);
        }
        return b;
    }

    @Test
    void mediaSemestreComDoisBimestresIguais() {
        Semestre s = new SemestreBase();
        s.addBimestre(bimestreComNotas(8.0, 8.0)); // N1 = 8.0
        s.addBimestre(bimestreComNotas(6.0, 6.0)); // N2 = 6.0
        assertEquals(7.0, s.media());
    }

    @Test
    void mediaSemestreAprovacaoDireta() {
        Semestre s = new SemestreBase();
        s.addBimestre(bimestreComNotas(7.0, 7.0)); // N1 = 7.0
        s.addBimestre(bimestreComNotas(7.0, 7.0)); // N2 = 7.0
        assertTrue(s.media() >= 6.0);
    }

    @Test
    void mediaSemestreFaixaRecuperacao() {
        Semestre s = new SemestreBase();
        s.addBimestre(bimestreComNotas(4.0, 4.0)); // N1 = 4.0
        s.addBimestre(bimestreComNotas(6.0, 6.0)); // N2 = 6.0 => M = 5.0
        double media = s.media();
        assertTrue(media >= 4.0 && media < 6.0);
    }

    @Test
    void mediaSemestreSemBimestresRetornaZero() {
        Semestre s = new SemestreBase();
        assertEquals(0.0, s.media());
    }
}

