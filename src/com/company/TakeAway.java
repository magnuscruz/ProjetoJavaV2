package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TakeAway extends Reserva implements Serializable {
    private ArrayList<Prato> listaPratos;
    private int quantidade;
    private double valorTotal;
    private Prato prato;

//    public TakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora, int quantidade) {
//        super(cliente, restaurante, data, hora);
//        this.quantidade = quantidade;
//        //this.valorTotal = //Colocar Metodo!
    // this.status = true;
//    }


///SO PARA TESTAR, TEM DE SER O DE CIMA O FINAL!////
public TakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora, int quantidade) {
    super(cliente, restaurante, data, hora);
    this.quantidade= quantidade;
    this.valorTotal = getValorTotal(); //FAZER METODO PARA CALcular o total a pagar! Preco vs qt,  tem é de aceder ao ArrayPratos
    this.status = true;
    this.prato = prato;
}


    @Override
    public String toString() {
        return "TakeAway{" + super.toString()+
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
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

    public void setListaPratos(ArrayList<Prato> listaPratos) {
        this.listaPratos = listaPratos;
    }

    public ArrayList<Prato> getListaPratos() {
        return listaPratos;
    }

}
