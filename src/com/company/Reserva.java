package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public abstract class  Reserva implements Serializable {

    protected String cliente;
    protected String restaurante;
    // protected Cliente cliente;
    //protected Restaurante restaurante;
    protected GregorianCalendar data;
    protected LocalTime horario;
    protected int hora;
    protected int minuto;


//    public Reserva(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto) {
//        this.cliente = cliente;
//        this.restaurante = restaurante;
//        this.data = data;
//        this.horario = LocalTime.of(hora,minuto);
//    }

    public Reserva(String cliente, String restaurante, int ano, int mes, int dia, int hora, int minuto) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = new GregorianCalendar(ano, (mes - 1), dia);
        this.horario = LocalTime.of(hora, minuto);
    }

    @Override
    public String toString() {
        return  "cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" + (data.get(GregorianCalendar.YEAR)+ "/" + (data.get(GregorianCalendar.MONTH )+1)+ "/" + data.get(GregorianCalendar.DAY_OF_MONTH))+
                ", horario=" + horario +
                '}';
    }
}
