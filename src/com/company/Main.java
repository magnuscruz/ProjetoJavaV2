package com.company;

import GUI.Frame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Sistema sistema = new Sistema();
        FicheiroDeObjectos ficheiroOb = new FicheiroDeObjectos();
        //sistema.listaComentarios.add(new Comentario ("MB", 4, (Cliente)sistema.listaUtilizadores.get(0), (Restaurante)sistema.listaUtilizadores.get(1), 12, 12, 2020));

        //sistema.listaUtilizadores.add(new Restaurante ("Z", "rua t", "4455555", "eee@hhh", "ert", 20, 10, 20, 11, 30, 15, 00, 17, 00, 23, 00));
        //sistema.listaUtilizadores.add(new Restaurante ("Z", "rua t", "4455555", "eee@hhh", "ert", 20, 10, 20, 11, 30, 15, 00, 17, 00, 23, 00));
        //sistema.listaUtilizadores.add(new Cliente ("Adriano", "rua x", "444545", "eeer@ggfg", "erd"));

        Frame f = new Frame();
        /*try {
            if (ficheiroOb.abreLeitura ("FicheiroProjeto.dat")) {
                System.out.println("abriu");
                sistema = (Sistema) ficheiroOb.leObjecto();
                ficheiroOb.abreEscrita("FicheiroProjeto.dat");
                ficheiroOb.escreveObjecto(sistema);
            }
        }
        catch (Exception e) {
            System.out.println("Ocorreu uma exceção " + e.getMessage());
        }

        ficheiroOb.fechaEscrita();
        ficheiroOb.fechaLeitura();*/


        System.out.println(sistema.listaUtilizadores);
        //System.out.println(sistema.listaComentarios);
    }

}
