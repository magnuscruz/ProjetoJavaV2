package com.company;

import GUI.Frame;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();


        // Frame f = new Frame();


        System.out.println("-----------------------------");
        System.out.println("Lista utilizadores: ");
        System.out.println(sistema.listaUtilizadores);
        System.out.println("--------------------------");
        System.out.println("Lista Comentarios: ");
        System.out.println(sistema.listaComentarios);
        System.out.println("---------------------------");
        System.out.println("Lista de Reservas");
        //System.out.println(sistema.utilizador.listaReservas);

    }

}
