package com.company;

import java.io.Serializable;

public class Presencial extends Reserva implements Serializable {
    private int zona;
    private int numeroLugares;

//    public Presencial(Cliente cliente, Restaurante restaurante, GregorianCalendar data, int hora, int minuto, int zona, int numeroLugares) {
//        super(cliente, restaurante, data, hora, minuto);
//        this.zona = zona;
//        this.numeroLugares = numeroLugares;
//    }

    public Presencial(String cliente, String restaurante, int ano, int mes, int dia, int hora, int minuto, int zona, int numeroLugares) {
        super(cliente, restaurante, ano, mes, dia, hora, minuto);
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
