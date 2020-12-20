package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Take_Away extends Reserva implements Serializable {
    private ArrayList<Prato> listaPratos;
    private int quantidade;
    private double valorTotal;

    public Take_Away(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto, ArrayList<Prato> listaPratos, int quantidade, double valorTotal) {
        super(cliente, restaurante, data, hora, minuto);
        this.listaPratos = listaPratos;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Take_Away{" +
                "listaPratos=" + listaPratos +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
