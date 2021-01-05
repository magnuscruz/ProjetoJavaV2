package com.company;


import com.company.gui.Interface;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Sistema sistema = new Sistema();
        //Frame f = new Frame();
//
//        sistema.criarRestaurante("A", "rua x", "Coimbra",
//                "111111111", "email1@com.pt", "user1",
//                "pass", "pass", 20, 10,
//                10, LocalTime.of(12, 00), LocalTime.of(14, 00),
//                LocalTime.of(19, 00), LocalTime.of(22, 00));
//
////        sistema.criarRestaurante("B", "rua y", "lisboa",
////                "222222222", "email2@com.pt", "user2",
////                "pass", "pass", 20, 10,
////                10, LocalTime.of(12,00), LocalTime.of(14,00),
////                LocalTime.of(19,00),LocalTime.of(22,00));
////
//
////        sistema.criarRestaurante("C", "rua z", "Porto",
////                "333333333", "email3@com.pt", "user3",
////                "pass", "pass", 20, 10,
////                10, LocalTime.of(12,00), LocalTime.of(14,00),
////                LocalTime.of(19,00),LocalTime.of(22,00));
//
////
////        sistema.criarCliente("A4", "cliente1@com.pt", "rua A", "444444444",
////                "cliente4", "pass", "pass");
////
////        sistema.criarCliente("B5", "cliente2@com.pt", "rua B", "555555555",
////                "cliente5", "pass", "pass");
////
//       sistema.criarCliente("C7", "cliente3@com.pt", "rua C", "777777777",
//               "cliente7", "pass", "pass");
//////
//
//        sistema.login("cliente7", "pass");
//
//        sistema.getClienteAtivo().criarReservaPresencial(sistema.getListaRestaurantes().get(0), new GregorianCalendar(2021, 03, 01),
//                LocalTime.of(13, 00), 1, 20);
//
//        sistema.adicionarComentario(sistema.getClienteAtivo(), "Excelente", 4, sistema.getListaRestaurantes().get(0));
//        sistema.adicionarComentario(sistema.getClienteAtivo(), "Ruim", 5, sistema.getListaRestaurantes().get(0));
//
//        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoAPratosDia("bitoque", "arroz e batatas", 10);
//        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoACarta("bitoque", "arroz e batatas", 30);
//
//
//        System.out.println("lista restaurantesa");
//        System.out.println(sistema.consultarListaComentariosPorCliente(sistema.getClienteAtivo().getNome()));
//        System.out.println("------");
//
//        System.out.println("PONTUACAO MEDIA "+ sistema.getPontuacaoMediaRestaurante(sistema.getListaRestaurantes().get(0)));
//        System.out.println("Preco MEDIO "+ sistema.getListaRestaurantes().get(0).getPrecoMedioRestaurante());
//        //System.out.println("Restaurantes por valores "+ sistema.consultarRestaurantePorValores(5,50));
//
//
////        sistema.getClienteAtivo().criarReservaPresencial(sistema.getListaRestaurantes().get(0), new GregorianCalendar(2021, 03, 01),
////                LocalTime.of(13, 00), 1, 20);
//
//        sistema.getClienteAtivo().criarReservaPresencial(sistema.getListaRestaurantes().get(0),
//                new GregorianCalendar(2020,01,10),LocalTime.of(13,00),1, 15);
//
//        System.out.println("Lista RESERVAS");
//
//        System.out.println(sistema.getClienteAtivo().getListaReservas());
//
//        System.out.println("--------------------");
//
////        sistema.getClienteAtivo().adicionarComentario("aaa", 3, sistema.getListaRestaurantes().get(0));
////        System.out.println(sistema.getListaComentarios());
//
//
//        //todo, criar ReservaPresencial - n funciona
////        sistema.login("userC1","pass");
////        sistema.getClienteAtivo().criarReservaPresencial(sistema.getListaRestaurantes().get(0), new GregorianCalendar(2021,1,5),
////                LocalTime.of(13,0), 1,20);
//
////        System.out.println("RESERVA");
////       System.out.println(sistema.getListaClientes().get(0).getListaReservas());
////       System.out.println("-----------------------------------------------------");
//
//
////       Utilizador u = sistema.listaUtilizadores.get(3);
////               if (u instanceof Cliente) {
////                   sistema.utilizador.listaReservas.add(new TakeAway((Cliente) sistema.listaUtilizadores.get(3), , 2020, 7, 5, 18, 30, 5));
////               }else {
////                   System.out.println("nao é um cliente");
////               }
//
////        System.out.println("LISTA RESERVAS");
////        if (sistema.getClienteAtivo() != null) {
////            ArrayList<Reserva> listaReservaC = sistema.getClienteAtivo().getListaReservas();
////        }
//
//
//
        System.out.println("LISTA UTILIZADORES");
        System.out.println(sistema.getListaUtilizadores());
        System.out.println("CLIENTE");
        System.out.println(sistema.getListaClientes());
        System.out.println("RESTAURANTE");
        System.out.println(sistema.getListaRestaurantes());

//
//        //                       sistema.gravarSistema();
sistema.login("cliente7", "pass");
        Interface sistemaGrafico = new Interface(sistema);
        sistemaGrafico.setVisible(true);
    }
}
