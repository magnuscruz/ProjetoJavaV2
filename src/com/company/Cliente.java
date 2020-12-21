package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Utilizador implements Serializable {
    private static int idCliente = 5000;
    ArrayList<Reserva> listaReservas = new ArrayList<>();

    public Cliente(String nome, String morada, String telefone, String email, String username, String password) {
        super(nome, morada, telefone, email, username, password);
        this.id = idCliente++;
    }

    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

}
