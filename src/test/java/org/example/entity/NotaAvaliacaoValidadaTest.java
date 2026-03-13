package org.example.entity;

import org.example.interfaces.Avaliavel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotaAvaliacaoValidadaTest {

    @Test
    void notaValidaRetornaValor() {
        Avaliavel nota = new NotaAvaliacaoValidada(new AvaliacaoBase(7.5));
        assertEquals(7.5, nota.nota());
    }

    @Test
    void notaZeroEhValida() {
        Avaliavel nota = new NotaAvaliacaoValidada(new AvaliacaoBase(0.0));
        assertEquals(0.0, nota.nota());
    }

    @Test
    void notaDezEhValida() {
        Avaliavel nota = new NotaAvaliacaoValidada(new AvaliacaoBase(10.0));
        assertEquals(10.0, nota.nota());
    }

    @Test
    void notaNegativaLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new NotaAvaliacaoValidada(new AvaliacaoBase(-0.1)));
    }

    @Test
    void notaAcimaDeDeZLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> new NotaAvaliacaoValidada(new AvaliacaoBase(10.1)));
    }
}

