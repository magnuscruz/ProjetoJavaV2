package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public abstract class Reserva implements Serializable {


    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    protected Integer idReserva;
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
        return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", restaurante=" + restaurante + ", data="
                + data + ", hora=" + hora + ", status=" + status + "]";
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

    public Integer getIdReserva() {
        return idReserva;
    }
}
