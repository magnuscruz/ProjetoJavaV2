package com.company;

import GUI.Frame;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();


        // Frame f = new Frame();


        sistema.criarRestaurante("Rest1", "ruaR1", "921", "mail1@a.pt", "userR1", "pass", "pass", 10, 10, 10, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        sistema.criarRestaurante("Rest2", "ruaR2", "912", "mail2@a.pt", "userR2", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        sistema.criarRestaurante("Rest3", "ruaR3", "9133", "mail3@aa.com", "userR3", "pass", "pass", 30, 30, 30, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));

        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoACarta("sardinhas", "assadas", 12.2);


        sistema.criarCliente("cli1", "RuaC1", "961", "mailR1@gmail.com", "userC1", "pass", "pass");
        sistema.criarCliente("cli2", "RuaC2", "962", "mailR2@gmail.com", "userC2", "pass", "pass");
        sistema.criarCliente("cli3", "RuaC3", "963", "mailR3@gmail.com", "userC3", "pass", "pass");


        sistema.criarCliente("Adriano", "Sesamo", "966", "adriano_t@out.com", "adriano", "pass", "pass");


        System.out.println("LISTA UTILIZADORES");
        System.out.println(sistema.getListaUtilizadores());
        System.out.println("---------------------");

        System.out.println("LISTA UTILIZADORES C STATUS TRUE");
        sistema.getListaUtilizadores().get(1).setStatus(false);
        sistema.getListaUtilizadores().get(4).setStatus(false);

//A forma de imprimir todos, excepto o que teem status false, sem ser com ciclo for??
        for (int i = 0; i < sistema.getListaUtilizadores().size(); i++) {
            if (sistema.getListaUtilizadores().get(i).getStatus() == true) {
                System.out.println(sistema.getListaUtilizadores().get(i));
            }
        }
        System.out.println("--------------------------------");

        ///NAO FUNCIONA O CRIAR RESERVA///
//
        System.out.println("CRIAR RESERVAS");
//        sistema.getClienteAtivo().criarReservaPresencial(
//                (Restaurante) sistema.getListaUtilizadores().get(1), new GregorianCalendar(2020, 10, 10), LocalTime.of(21, 00), 1, 5);
      //  System.out.println(sistema.getClienteAtivo().getListaReservas());
        System.out.println("---------------------");


        System.out.println("LISTACOMENTARIOS");
        sistema.adicionarComentarioCliente(sistema.getClienteAtivo(),
                "Excelente", 4,
                (Restaurante) sistema.getListaUtilizadores().get(0));
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

        //ESTA PARTE É PARA COLOCAR NA INTERFACE
//        if (resultado.length()==0){
//            // criar janel de login com sucesso
//        } else {
//            // criar janela com mensagem de erro
//        }

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


//            String resultadoo = sistema.login("joao","xpto");
//            if (resultado.length()==0){
//                // criar janel de login com sucesso
//            } else {
//                // criar janela com mensagem de erro
//            }

        // ArrayList<Reserva> listaReservaR = sistema.getRestauranteAtivo().getListaReservas();
        //   }


        //sistema.utilizador.cliente.restauranteAberto(18,30);
        System.out.println("--------------------");


//       if ( sistema.cliente.restauranteAberto(16,00)){
//           System.out.println("Fechado");
//       } else System.out.println("Aberto");


    }

}
