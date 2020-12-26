package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Presencial extends Reserva implements Serializable {
    private int zona;
    private int numeroLugares;

    public Presencial(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int zona, int numeroLugares) {
        super(cliente, restaurante, data, horario);
        this.zona = zona;
        this.numeroLugares = numeroLugares;
    }

    @Override
    public String toString() {
        return "Presencial{" + super.toString()+
                "zona=" + zona +
                ", numeroLugares=" + numeroLugares +
                '}';
    }
}
