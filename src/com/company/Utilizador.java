package com.company;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Utilizador implements Serializable {

    Restaurante restaurante;
    Cliente cliente;

    private ArrayList<Reserva> listaReservas = new ArrayList<>();// cada utilizador vai ter a sua lista.

    protected int id;
    protected String nome;
    protected String morada;
    protected String telefone;
    protected String email;
    protected String username;
    protected String password;
    protected String confirmarPass;
    protected boolean status;

    Utilizador() {
    }

    public Utilizador(String nome, String morada, String telefone, String email, String username, String password, String confirmarPass) {
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmarPass = confirmarPass;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + password + '\'' +
                '}';
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPrecoMedioReservaTakeAway() {
        double media = 0;
        double precoTotal = 0;
        int count =0;
        for (Reserva r : getListaReservas()) {
            if (r instanceof TakeAway) {
                precoTotal += ((TakeAway) r).getValorTotal();
            }
        }
        if (count > 0){
            return media = precoTotal/count;
        }
        JOptionPane.showMessageDialog(null, "Sem reservas TakeAway!");
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}