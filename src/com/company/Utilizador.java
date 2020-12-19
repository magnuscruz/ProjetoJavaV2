package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Utilizador implements Serializable {
    private static int idd = 1;
    private static int idRestaurante;
    private static int idCliente;

    ArrayList<Comentario> listaComentarios = new ArrayList<>();
    ArrayList<Reserva> listaReservas = new ArrayList<>();

    private int id;
    private String nome;
    private String morada;
    private String telefone;
    private String email;
    private String username;
    private String password;


    public Utilizador(String nome, String morada, String telefone, String email, String username, String password) {
        this.id = idd++;
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.username = username;
        this.password = password;

    }

    @Override
    public String toString() {
        return "\nUtilizador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}