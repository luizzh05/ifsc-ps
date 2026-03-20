package org.example.interfaces;

import java.util.List;

public interface Semestre {
    void addBimestre(Bimestre bimestre);
    double media();
    List<Bimestre> bimestres();
}
