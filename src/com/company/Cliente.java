package com.company;

import java.io.Serializable;

public class Cliente extends Utilizador  {


    public Cliente(String nome, String morada, String telefone, String email, String username, String password) {
        super(nome, morada, telefone, email, username, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
