package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Reserva implements Serializable {

    private Cliente cliente;
    private Restaurante restaurante;
    private GregorianCalendar data;
    private LocalTime horario;
    private int hora;
    private int minuto;


    public Reserva(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.data = data;
        this.horario = LocalTime.of(hora,minuto);


    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" + data +
                ", horario=" + horario +
                '}';
    }
}
