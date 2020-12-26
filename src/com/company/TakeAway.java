package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TakeAway extends Reserva implements Serializable {
    private ArrayList<Prato> listaPratos;
    private int quantidade;
    private double valorTotal;



//    public TakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario , ArrayList<Prato> listaPratos, int quantidade, double valorTotal) {
//        super(cliente, restaurante, data, hora, minuto);
//        this.listaPratos = listaPratos;
//        this.quantidade = quantidade;
//        this.valorTotal = valorTotal;
//    }

/////SO PARA TESTAR, TEM DE SER O DE CIMA O FINAL!////
public TakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int quantidade, int valorTotal) {
    super(cliente, restaurante, data, horario);
    this.quantidade= quantidade;
    this.valorTotal = getValorTotal(); //FAZER METODO PARA CALcular o total a pagar! Preco vs qt,  tem é de aceder ao ArrayPratos

}

    @Override
    public String toString() {
        return "TakeAway{" + super.toString()+
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;

    }

    public ArrayList<Prato> getListaPratos() {
        return listaPratos;
    }

    public void setListaPratos(ArrayList<Prato> listaPratos) {
        this.listaPratos = listaPratos;
    }
}
