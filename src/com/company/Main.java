package com.company;


import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        //Frame f = new Frame();

        sistema.criarRestaurante("Rest1", "ruaR1", "Lisboa", "921", "mail1@a.pt", "userR1", "pass", "pass", 10, 10, 10, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        sistema.criarRestaurante("Rest2", "ruaR2", "Coimbra", "912", "mail2@a.pt", "userR2", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        sistema.criarRestaurante("Rest3", "ruaR3", "Porto", "9133", "mail3@aa.com", "userR3", "pass", "pass", 30, 30, 30, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
     //   sistema.getListaUtilizadores().get(0).setStatus(false);

        sistema.getListaRestaurantes().get(1).getEmenta().adicionarPratoACarta("sardinhas", "assadas", 12.2);

        sistema.criarCliente("cli1", "RuaC1", "961", "mailR1@gmail.com", "userC1", "pass", "pass");
        sistema.criarCliente("cli2", "RuaC2", "962", "mailR2@gmail.com", "userC2", "pass", "pass");
        sistema.criarCliente("cli3", "RuaC3", "963", "mailR3@gmail.com", "userC3", "pass", "pass");



//        System.out.println("RESERVA");
//        System.out.println(sistema.getListaClientes().get(0).getListaReservas());
//        System.out.println("-----------------------------------------------------");

       sistema.adicionarComentarioCliente(sistema.getListaClientes().get(0), "Excelente", 5,sistema.getListaRestaurantes().get(1));

//        System.out.println("LISTA COMENTARIOS");
//        System.out.println(sistema.getListaClientes().get(0).getListaComentarios());
//        System.out.println("--------------------------------");

//        System.out.println("LISTA UTILIZADORES");
//        System.out.println(sistema.getListaUtilizadores());
//        System.out.println("---------------------");
//
        System.out.println("LISTA RESTAURANTES");
        System.out.println(sistema.getListaRestaurantes());
        System.out.println("---------------------");


        System.out.println("LISTACOMENTARIOS");

//        sistema.adicionarComentarioCliente(sistema.getClienteAtivo(),
//                "Excelente", 4,
//                (Restaurante) sistema.getListaUtilizadores().get(0));
        sistema.adicionarComentarioCliente(sistema.getClienteAtivo(),
                "Horrivel", 4,
                (Restaurante) sistema.getListaUtilizadores().get(2));

        //       sistema.listaComentarios.add(new Comentario("Horrivel", 4, (Cliente) sistema.listaUtilizadores.get(3),(Restaurante) sistema.listaUtilizadores.get(2)));
        System.out.println(sistema.getListaComentarios());
        System.out.println("----------------------");


        //Neste ciclo, só vai buscar os comentarios de restaurante X, esta é feito à PEDREIRO!
        for (int i = 0; i < sistema.getListaComentarios().size(); i++) {
            if (sistema.getListaComentarios().get(i).getRestaurante().equals(sistema.getListaUtilizadores().get(0))) {
                System.out.println(sistema.getListaComentarios().get(i));
            }
        }

//       Utilizador u = sistema.listaUtilizadores.get(3);
//               if (u instanceof Cliente) {
//                   sistema.utilizador.listaReservas.add(new TakeAway((Cliente) sistema.listaUtilizadores.get(3), , 2020, 7, 5, 18, 30, 5));
//               }else {
//                   System.out.println("nao é um cliente");
//               }


        System.out.println("LISTA RESERVAS");
        if (sistema.getClienteAtivo() != null) {
            ArrayList<Reserva> listaReservaC = sistema.getClienteAtivo().getListaReservas();

        }


        // ArrayList<Reserva> listaReservaR = sistema.getRestauranteAtivo().getListaReservas();
        //   }


        //sistema.utilizador.cliente.restauranteAberto(18,30);
        System.out.println("--------------------");


//       if ( sistema.cliente.restauranteAberto(16,00)){
//           System.out.println("Fechado");
//       } else System.out.println("Aberto");


    }

}
