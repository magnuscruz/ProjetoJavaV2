package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TakeAway extends Reserva implements Serializable {
    private ArrayList<Prato> listaPratos;
    private int quantidade;
    private double valorTotal;

//    public TakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto, ArrayList<Prato> listaPratos, int quantidade, double valorTotal) {
//        super(cliente, restaurante, data, hora, minuto);
//        this.listaPratos = listaPratos;
//        this.quantidade = quantidade;
//        this.valorTotal = valorTotal;
//    }

/////SO PARA TESTAR, TEM DE SER O DE CIMA O FINAL!////
    public TakeAway(Cliente cliente, Restaurante restaurante, int ano, int mes, int dia, int hora, int minuto, int quantidade) {
        super(cliente, restaurante, ano, mes, dia, hora, minuto);
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "TakeAway{" + super.toString()+
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }

}
