package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Presencial extends Reserva implements Serializable {
    private int zona;
    private int numeroLugares;

    public Presencial(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto, int zona, int numeroLugares) {
        super(cliente, restaurante, data, hora, minuto);
        this.zona = zona;
        this.numeroLugares = numeroLugares;
    }

    @Override
    public String toString() {
        return "Presencial{" +
                "zona=" + zona +
                ", numeroLugares=" + numeroLugares +
                '}';
    }
}
