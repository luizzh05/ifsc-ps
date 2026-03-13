package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArredondadorMediaTest {

    private final ArredondadorMedia arredondador = new ArredondadorMedia();

    @Test
    void arredondaParaCimaNaMeioTerminho() {
        // 5.75 -> 6.0
        assertEquals(6.0, arredondador.arredondar(5.75));
    }

    @Test
    void arredondaParaBaixoAbaixoDoMeioTerminho() {
        // 5.2 -> 5.0
        assertEquals(5.0, arredondador.arredondar(5.2));
    }

    @Test
    void mantemValorJaArredondado() {
        assertEquals(6.0, arredondador.arredondar(6.0));
    }

    @Test
    void arredondaParaMeioPonto() {
        // 5.3 -> 5.5
        assertEquals(5.5, arredondador.arredondar(5.3));
    }

    @Test
    void arredondaZero() {
        assertEquals(0.0, arredondador.arredondar(0.0));
    }

    @Test
    void arredondaDez() {
        assertEquals(10.0, arredondador.arredondar(10.0));
    }
}

