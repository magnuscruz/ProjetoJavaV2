package com.company;

import java.io.Serializable;
import java.util.ArrayList;


public class Sistema implements Serializable {
    public ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    public ArrayList<Comentario> listaComentarios = new ArrayList<>();
    protected Utilizador utilizarAtivo;

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

    public ArrayList <Restaurante> getListaRestaurantes (){
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        for (Utilizador u: listaUtilizadores) {
            if (u instanceof Restaurante){
                restaurantes.add((Restaurante) u);
        }
        }
        return restaurantes;
    }

    public String login(String username, String pass){
        /// percorrer lista de utilizadores ate encontrar client
        // verificar password
        if(username.equals("restaurante")){
            Utilizador u = listaUtilizadores.get(1);

        } else {

            Utilizador u = listaUtilizadores.get(3);
        }
        // se login for valido
       // this.utilizarAtivo = u;
        return "";
        // Se login invalido
//        this.utilizarAtivo = null;
//        return "Utilizador inválido";
    }

    private Utilizador getUtilizarAtivo (){

        return this.utilizarAtivo;
    }

    public Cliente getClienteAtivo() {
        if( getUtilizarAtivo() instanceof Cliente){
            return (Cliente) getUtilizarAtivo();
        }
        return null;
    }

    public Restaurante getRestauranteAtivo() {
        if( getUtilizarAtivo() instanceof Restaurante){
            return (Restaurante) getUtilizarAtivo();
        }
        return null;
    }
}
