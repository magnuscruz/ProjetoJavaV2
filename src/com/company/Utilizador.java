package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Utilizador implements Serializable {
  //  private static int idd;
   // private static int idRestaurante;
  //  private static int idCliente;

    ArrayList<Comentario> listaComentarios = new ArrayList<>();
    //ArrayList<Reserva> listaReservas = new ArrayList<>();

    protected int id;
    protected String nome;
    protected String morada;
    protected String telefone;
    protected String email;
    protected String username;
    protected String password;


    public Utilizador(String nome, String morada, String telefone, String email, String username, String password) {

        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.username = username;
        this.password = password;

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
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