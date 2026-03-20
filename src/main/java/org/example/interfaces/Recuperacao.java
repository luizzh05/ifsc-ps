package org.example.interfaces;

public interface Recuperacao {
    boolean elegivel(double frequenciaPercentual, double mediaSemestral);
    boolean calcularMediaFinal(double n1, double n2, double notaRecuperacao);
}
