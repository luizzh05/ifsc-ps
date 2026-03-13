package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.example.interfaces.Bimestre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorMediaBimestreTest {

    private Bimestre bimestreComNotas(double... notas) {
        Bimestre b = new BimestreBase();
        for (double nota : notas) {
            Avaliavel av = new NotaAvaliacaoValidada(new AvaliacaoBase(nota));
            b.addAvaliacao(av);
        }
        return b;
    }

    @Test
    void mediaDeUmaNota() {
        Bimestre b = bimestreComNotas(8.0);
        assertEquals(8.0, b.media());
    }

    @Test
    void mediaDeDuasNotasIguais() {
        Bimestre b = bimestreComNotas(6.0, 6.0);
        assertEquals(6.0, b.media());
    }

    @Test
    void mediaDeDuasNotasDiferentes() {
        Bimestre b = bimestreComNotas(4.0, 8.0);
        assertEquals(6.0, b.media());
    }

    @Test
    void mediaSemAvaliacoesRetornaZero() {
        Bimestre b = new BimestreBase();
        assertEquals(0.0, b.media());
    }

    @Test
    void mediaComNotaZeroEDez() {
        Bimestre b = bimestreComNotas(0.0, 10.0);
        assertEquals(5.0, b.media());
    }
}

