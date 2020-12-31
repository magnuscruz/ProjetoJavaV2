package com.company;


import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        //Frame f = new Frame();

        sistema.criarRestaurante("Rest1", "ruaR2", "Coimbra", "912", "MAIL1@a.pt", "userR1", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
       // sistema.criarRestaurante("Rest2", "ruaR2", "Porto", "913", "mail2@a.pt", "userR2", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
      //  sistema.criarRestaurante("Rest3", "ruaR3", "Lisboa", "9133", "mail3@aa.com", "userR3", "pass", "pass", 30, 30, 30, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));

        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoACarta("sardinhas", "assadas", 20);
        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoAPratosDia("bitoque", "arroz e batatas", 10);


     //   sistema.getListaRestaurantes().get(1).getEmenta().adicionarPratoAPratosDia("bitoque", "arroz e batatas", 50);
       // sistema.getListaRestaurantes().get(1).getEmenta().adicionarPratoAPratosDia("bitoque", "arroz e batatas", 70);

//        System.out.println("RESTAURANTES PRECO MEDIO");
//        // todo aqui o metodo fazer preco medio de Restaurante funciona...
//        System.out.println(sistema.getListaRestaurantes().get(0).getPrecoMedioRestaurante());
//        System.out.println("-------------------------------------------------------");

//        System.out.println("RESTAURANTES POR FILTROS");
//        System.out.println(sistema.consultarRestaurantePorValores(10,20));
//        System.out.println("-------------------------------------------------------------");

        sistema.criarCliente("cli1", "RuaC1", "961", "mailR1@gmail.com", "userC1", "pass", "pass");
      //  sistema.criarCliente("cli2", "RuaC2", "962", "mailR2@gmail.com", "userC2", "pass", "pass");
      //  sistema.criarCliente("cli3", "RuaC3", "963", "mailR3@gmail.com", "userC3", "pass", "pass");

        //System.out.println("LISTA RESTAURANTES");
        //todo, aqui novamente nao imprime
       // System.out.println(sistema.getListaRestaurantes());
       // System.out.println("---------------------");



//        System.out.println("RESERVA");
//       System.out.println(sistema.getListaClientes().get(0).getListaReservas());
//       System.out.println("-----------------------------------------------------");

     //  sistema.adicionarComentarioCliente(sistema.getListaClientes().get(0), "Excelente", 5,sistema.getListaRestaurantes().get(1));

//        System.out.println("LISTA COMENTARIOS");
//        System.out.println(sistema.getListaClientes().get(0).getListaComentarios());
//        System.out.println("--------------------------------");

//        System.out.println("LISTACOMENTARIOS");
//        sistema.adicionarComentarioCliente(sistema.getClienteAtivo(),
//                "Excelente", 4,
//                (Restaurante) sistema.getListaUtilizadores().get(0));
//        sistema.adicionarComentarioCliente(sistema.getClienteAtivo(),
//                "Horrivel", 4,
//                (Restaurante) sistema.getListaUtilizadores().get(2));

        //       sistema.listaComentarios.add(new Comentario("Horrivel", 4, (Cliente) sistema.listaUtilizadores.get(3),(Restaurante) sistema.listaUtilizadores.get(2)));
//        System.out.println(sistema.getListaComentarios());
//        System.out.println("----------------------");


//       Utilizador u = sistema.listaUtilizadores.get(3);
//               if (u instanceof Cliente) {
//                   sistema.utilizador.listaReservas.add(new TakeAway((Cliente) sistema.listaUtilizadores.get(3), , 2020, 7, 5, 18, 30, 5));
//               }else {
//                   System.out.println("nao é um cliente");
//               }

//        System.out.println("LISTA RESERVAS");
//        if (sistema.getClienteAtivo() != null) {
//            ArrayList<Reserva> listaReservaC = sistema.getClienteAtivo().getListaReservas();
//        }



    }

}
