package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public abstract class  Reserva implements Serializable {

//    protected String cliente;
//    protected String restaurante;
     protected Cliente cliente;
    protected Restaurante restaurante;
    protected GregorianCalendar data;
    protected LocalTime horario;



    public Reserva(Cliente cliente, Restaurante restaurante,GregorianCalendar  data, LocalTime horario ) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = data;
        this.horario = horario;
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
