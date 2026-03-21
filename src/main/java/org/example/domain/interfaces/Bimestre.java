package org.example.domain.interfaces;

import java.util.List;

public interface Bimestre {
    double media();
    void addAvaliacao(Avaliavel avaliacao);
    List<Avaliavel> avaliacoes();
}
