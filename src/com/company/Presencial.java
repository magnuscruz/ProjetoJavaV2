
package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.GregorianCalendar;

public class Presencial extends Reserva implements Serializable {
    private static int idEstaticoPresencial = 1;
    private int zona;
    private int numeroLugares;

    public Presencial(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora, int zona, int numeroLugares) {
        super(cliente, restaurante, data, hora);
        this.zona = zona;
        // this.zona = restaurante.zonaDisponibilidade(data,hora,zona,numeroLugares);
        this.numeroLugares = numeroLugares;
        this.idReserva = idEstaticoPresencial;
        this.status = true;
    }

    @Override
    public String toString() {
        return "Presencial{" + super.toString()+
                "zona=" + zona +
                ", numeroLugares=" + numeroLugares +
                '}';
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }
}