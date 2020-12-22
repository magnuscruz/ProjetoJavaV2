package com.company;

import GUI.Frame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();

        // Frame f = new Frame();
        sistema.listaUtilizadores.add(new Restaurante("Tacho", "rua t", "4455555", "eee@hhh", "aaa", "ert", 20, 10, 20, 11, 30, 15, 00, 17, 00, 23, 00));
        sistema.listaUtilizadores.add(new Restaurante("Tacho2", "rua t", "4455555", "eee@hhh", "aaa", "ert", 20, 10, 20, 11, 30, 15, 00, 17, 00, 23, 00));
        sistema.listaUtilizadores.add(new Restaurante("Tacho3", "rua t", "4455555", "eee@hhh", "aaa", "ert", 20, 10, 20, 11, 30, 15, 00, 17, 00, 23, 00));
        sistema.listaUtilizadores.add(new Cliente("Xico", "Rua", "966", "ze@a.pt", "Zezeze", "111111"));
        sistema.listaUtilizadores.add(new Cliente("Xico2", "Rua", "966", "ze@a.pt", "Zezeze", "111111"));
        sistema.listaUtilizadores.add(new Cliente("Xico3", "Rua", "966", "ze@a.pt", "Zezeze", "111111"));
        sistema.utilizador.listaComentarios.add(new Comentario("Excelente", 4, sistema.listaUtilizadores.get(3).getNome(), sistema.listaUtilizadores.get(0).getNome()));
        //sistema.listaComentarios.add(new Comentario("Excelente", 5, (Cliente) sistema.listaUtilizadores.get(2), (Restaurante)sistema.listaUtilizadores.get(1), 01,2, 2020 ));
        //sistema.utilizador.listaReservas.add(new Take_Away("Zeca", "Tacho", 2020, 7, 5, 18, 30, 5));




//       if ( sistema.cliente.restauranteAberto(16,00)){
//           System.out.println("Fechado");
//       } else System.out.println("Aberto");

//        System.out.println("-----------------------------");
//        System.out.println("Lista utilizadores: ");
//        System.out.println(sistema.listaUtilizadores);
//        System.out.println("--------------------------");
//        System.out.println("Lista Comentarios: ");
//        System.out.println(sistema.utilizador.listaComentarios);
//        System.out.println("---------------------------");
//        System.out.println("Lista de Reservas");
//        System.out.println(sistema.utilizador.listaReservas);

    }

}
