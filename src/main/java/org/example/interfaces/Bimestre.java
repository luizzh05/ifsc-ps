package org.example.interfaces;

public interface Bimestre {
    double media();
    void addAvaliacao(Avaliavel avaliacao);
    int quantidadeAvaliacoes();
    double notaAvaliacao(int indice);
}
