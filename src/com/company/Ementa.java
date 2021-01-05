package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Ementa implements Serializable {

    private static int idEmentaEstatico = 1;
    private int idEmenta;
    private ArrayList<Prato> carta;
    private ArrayList<Prato> pratosDia;

    public Ementa(){
        this.idEmenta = idEmentaEstatico++;
        carta = new ArrayList<Prato>();
        pratosDia = new ArrayList<Prato>();
    }

    public Ementa(ArrayList<Prato> carta, ArrayList<Prato> pratosDia) {
        this.carta = carta;
        this.pratosDia = pratosDia;
    }


    public void adicionarPratoACarta( String nome, String descricao, double preco) {
        Prato p = new Prato(nome, descricao, preco);
        carta.add(p);
    }

    public void adicionarPratoAPratosDia(String nome, String descricao, double preco) {
        Prato p = new Prato(nome, descricao, preco);
        pratosDia.add(p);
    }

    public ArrayList<Prato> getCarta() {
        return carta;
    }

    public ArrayList<Prato> getPratosDia() {
        return pratosDia;
    }

    public int getIdEmenta() {
        return idEmenta;
    }

    @Override
    public String toString() {
        return "Ementa{" +
                "id " + idEmenta +
                "carta=" + carta +
                ", pratosDia=" + pratosDia +
                '}';
    }
}
