package org.example.domain.interfaces;

public interface Recuperacao {
    boolean elegivel(double frequenciaPercentual, double mediaSemestral);
    double calcularMediaFinal(double n1, double n2, double notaRecuperacao);
}
