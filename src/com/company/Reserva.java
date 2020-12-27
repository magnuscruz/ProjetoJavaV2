package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public abstract class Reserva implements Serializable {


    protected Cliente cliente;
    protected Restaurante restaurante;
    protected GregorianCalendar data;
    protected LocalTime hora;
    protected Boolean status;


    public Reserva(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = data;
        this.hora = hora;
        this.status = true;
    }


    @Override
    public String toString() {
        return "cliente=" + cliente +
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
