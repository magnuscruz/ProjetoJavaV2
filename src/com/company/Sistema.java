package com.company;

import java.io.Serializable;
import java.util.ArrayList;


public class Sistema implements Serializable {
    public ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    public ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private Utilizador utilizarAtivo;

//    ArrayList<Reserva> listaReservas = new ArrayList<>();
    protected Cliente cliente;

    public void utilizadorExiste(String username) {
        boolean a = true;
        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (username.equalsIgnoreCase(listaUtilizadores.get(i).getUsername())) {
                String nomeClasse = listaUtilizadores.get(i).getClass().getSimpleName();//// Imprime o nome da Classe. Tem é de se associar a uma variavel
                System.out.println("Utilizador com o username: " + listaUtilizadores.get(i).getUsername() + " é do tipo: " + nomeClasse);
                a = false;
            }
        }
        if (a) {
            System.out.println("Nao existe");
        }
    }

}
