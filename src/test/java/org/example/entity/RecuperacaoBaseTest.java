package org.example.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecuperacaoBaseTest {

    private RecuperacaoBase recuperacao;

    @BeforeEach
    void setUp() {
        recuperacao = new RecuperacaoBase();
    }

    // --- elegivel ---

    @Test
    void elegivelComFrequenciaEMediaNaFaixa() {
        assertTrue(recuperacao.elegivel(75.0, 4.0));
    }

    @Test
    void elegivelComFrequenciaAltaEMediaNaFaixa() {
        assertTrue(recuperacao.elegivel(100.0, 5.5));
    }

    @Test
    void naoElegivelFrequenciaAbaixoDe75() {
        assertFalse(recuperacao.elegivel(74.9, 5.0));
    }

    @Test
    void naoElegivelMediaAbaixoDe4() {
        assertFalse(recuperacao.elegivel(80.0, 3.9));
    }

    @Test
    void naoElegivelMediaIgualOuAcimaDe6() {
        assertFalse(recuperacao.elegivel(80.0, 6.0));
    }

    @Test
    void naoElegivelMediaAcimaDe6() {
        assertFalse(recuperacao.elegivel(80.0, 8.0));
    }

    @Test
    void naoElegivelFrequenciaZero() {
        assertFalse(recuperacao.elegivel(0.0, 5.0));
    }

    // --- calcularMediaFinal ---

    @Test
    void mediaFinalComN1MaiorQueN2() {
        // N1=8, N2=4 => Nmaior=8, R=7 => Mfinal=(8+7)/2 = 7.5
        assertEquals(7.5, recuperacao.calcularMediaFinal(8.0, 4.0, 7.0));
    }

    @Test
    void mediaFinalComN2MaiorQueN1() {
        // N1=3, N2=7 => Nmaior=7, R=6 => Mfinal=(7+6)/2 = 6.5
        assertEquals(6.5, recuperacao.calcularMediaFinal(3.0, 7.0, 6.0));
    }

    @Test
    void mediaFinalComN1IgualN2() {
        // N1=5, N2=5 => Nmaior=5, R=8 => Mfinal=(5+8)/2 = 6.5
        assertEquals(6.5, recuperacao.calcularMediaFinal(5.0, 5.0, 8.0));
    }

    @Test
    void mediaFinalResultaAprovado() {
        // N1=6, N2=4 => Nmaior=6, R=6 => Mfinal=6.0
        assertTrue(recuperacao.calcularMediaFinal(6.0, 4.0, 6.0) >= 6.0);
    }

    @Test
    void mediaFinalResultaReprovado() {
        // N1=5, N2=4 => Nmaior=5, R=4 => Mfinal=4.5
        assertTrue(recuperacao.calcularMediaFinal(5.0, 4.0, 4.0) < 6.0);
    }

    // --- validacoes de entrada ---

    @Test
    void frequenciaInvalidaLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> recuperacao.elegivel(-1.0, 5.0));
    }

    @Test
    void frequenciaAcimaDe100LancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> recuperacao.elegivel(101.0, 5.0));
    }

    @Test
    void notaRecuperacaoInvalidaLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> recuperacao.calcularMediaFinal(5.0, 5.0, 11.0));
    }

    @Test
    void notaNegativaLancaExcecao() {
        assertThrows(IllegalArgumentException.class,
                () -> recuperacao.calcularMediaFinal(5.0, 5.0, -1.0));
    }
}

