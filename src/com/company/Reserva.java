package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public abstract class Reserva implements Serializable {


    protected  int idReserva;
    protected Cliente cliente;
    protected Restaurante restaurante;
    protected GregorianCalendar data;
    protected LocalTime hora;
    protected boolean status;


    public Reserva(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = data;
        this.hora = hora;
    }


    @Override
    public String toString() {
        return "id "+ idReserva+
                " cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" + (data.get(GregorianCalendar.YEAR) + "/" + (data.get(GregorianCalendar.MONTH) + 1) + "/" + data.get(GregorianCalendar.DAY_OF_MONTH)) +
                ", hora=" + hora +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
