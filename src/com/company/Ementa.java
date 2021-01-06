package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Ementa implements Serializable {

    private static int idEmentaEstatico = 1;
    private int idEmenta;
    private ArrayList<Prato> carta;
    private ArrayList<Prato> pratosDia;

    public Ementa(){
        this.idEmenta = idEmentaEstatico++;
        carta = new ArrayList<Prato>();
        pratosDia = new ArrayList<Prato>();
    }

    public Ementa(ArrayList<Prato> carta, ArrayList<Prato> pratosDia) {

        for (Prato p: getCarta()){
            if (p.getStatus()){
                this.carta = carta;
            }
        }
        for (Prato p: getPratosDia()){
            if (p.getStatus()){
                this.pratosDia = pratosDia;
            }
        }
    }

    public void adicionarPrato( String nome, String descricao, double preco, String letra) {

        if (letra.equals("c")) {
            Prato p = new Prato(nome, descricao, preco);
            carta.add(p);
        }
        else if (letra.equals("p")){
            Prato p = new Prato(nome, descricao, preco);
            pratosDia.add(p);
        }
    }

    public void removerPratoCarta (int id){

        for (Prato p: getCarta()){
            if (p.getIdPrato()==id){
                p.setStatus(false);
                carta.remove(p);
                break;
            }
        }

    }
    //TODO - Nao é o ideal!! estao a fazer remove, e elimina atraves do ID... tentar ver se ha outra maneira atraves da interface
    public void removerPratoDia (int id){
        for (Prato p: getPratosDia()){
            if (p.getIdPrato()==id){
                p.setStatus(false);
                pratosDia.remove(p);
                break;
            }
        }
    }

    public ArrayList<Prato> getCarta() {
        return carta;
    }

    public ArrayList<Prato> getPratosDia() {
        return pratosDia;
    }

    public int getIdEmenta() {
        return idEmenta;
    }



    @Override
    public String toString() {
        return "Ementa{" +
                "id " + idEmenta +
                "carta=" + carta +
                ", pratosDia=" + pratosDia +
                '}';
    }
}