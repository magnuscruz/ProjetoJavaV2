package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Take_Away extends Reserva implements Serializable {
    private ArrayList<Prato> listaPratos;
    private int quantidade;
    private double valorTotal;

//    public Take_Away(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto, ArrayList<Prato> listaPratos, int quantidade, double valorTotal) {
//        super(cliente, restaurante, data, hora, minuto);
//        this.listaPratos = listaPratos;
//        this.quantidade = quantidade;
//        this.valorTotal = valorTotal;
//    }


    public Take_Away(String cliente, String restaurante, int ano, int mes, int dia, int hora, int minuto, int quantidade) {
        super(cliente, restaurante, ano, mes, dia, hora, minuto);
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Take_Away{" + super.toString()+
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
