package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Reserva implements Serializable {

    private Cliente cliente;
    private Restaurante restaurante;
    private GregorianCalendar data;
    private LocalTime hora;


    public Reserva(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = data;
        this.hora = hora;

    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}
