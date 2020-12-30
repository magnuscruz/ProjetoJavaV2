package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Ementa implements Serializable {

    private ArrayList<Prato> carta;
    private ArrayList<Prato> pratosDia;

    public Ementa(){
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

    public double precoMedioRestaurante(){
        double countCarta = 0;
        double countDia = 0;
        double precoTotalCarta = 0;
        double precoTotalDia = 0;

        for (Prato p : getCarta()){
            precoTotalCarta += p.getPreco();
            countCarta++;
        }

        for ( Prato p : getPratosDia()){
            precoTotalDia +=p.getPreco();
            countDia++;
        }
        return (precoTotalCarta + precoTotalDia) / (countCarta + countDia);
    }


    @Override
    public String toString() {
        return "Ementa{" +
                "carta=" + carta +
                ", pratosDia=" + pratosDia +
                '}';
    }
}
