package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Ementa implements Serializable {

    private ArrayList<Prato> carta;
    private ArrayList<Prato> pratosDia;

    public Ementa(ArrayList<Prato> carta, ArrayList<Prato> pratosDia) {
        this.carta = carta;
        this.pratosDia = pratosDia;
    }
}
