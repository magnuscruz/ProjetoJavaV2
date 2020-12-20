package com.company;

import java.io.Serializable;

public class Cliente extends Utilizador {
    private static int idCliente = 5000;

    public Cliente(String nome, String morada, String telefone, String email, String username, String password) {
        super(nome, morada, telefone, email, username, password);
        this.id = idCliente++;
    }

    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

//    public void criarReservaTakeAway(String cliente, String restaurante, int ano, int mes, int dia, int hora, int minuto, int numPessoas) {
//        listaReservas.add(new Take_Away("Pedro", "Xpto", 2020, 10, 1, 20, 10,10));
//    }

}
