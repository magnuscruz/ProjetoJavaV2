package com.company;


import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        //Frame f = new Frame();


        sistema.criarRestaurante("Rest1", "ruaR2", "Coimbra", "961876453", "MAIL1@a.pt", "userR1", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        sistema.criarRestaurante("Rest2", "ruaR2", "Coimbra", "961876454", "MAIL2@a.pt", "userR2", "pass", "pass", 20, 20, 20, LocalTime.of(12, 30), LocalTime.of(15, 00), LocalTime.of(20, 30), LocalTime.of(23, 59));
        sistema.criarRestaurante("Rest3", "ruaR2", "Coimbra", "961876455", "MAIL3@a.pt", "userR3", "pass", "pass", 20, 20, 20, LocalTime.of(13, 30), LocalTime.of(15, 00), LocalTime.of(21, 30), LocalTime.of(23, 59));


        sistema.criarCliente("cli1", "RuaC1", "961876457", "mailR1@gmail.com", "userC1", "pass", "pass");
        sistema.login("userC1", "pass");
        sistema.atualizarDadosCliente("", "RUA", "91", "adada", "", "aaa", "");


        sistema.login("userR1", "pass");
        System.out.println("Lotacao disponivel");
        double a = sistema.lotacaoTotalDisponivel();
        System.out.println(a);
        System.out.println("-----------------------");
        sistema.atualizarDadosRestaurante("TACHO", "", "", "", "", "", "", 10,
                10, 10, null, null, null, null);

        System.out.println("Restaurantes depois de editados");
        System.out.println(sistema.getListaRestaurantes());
        System.out.println("----------------");


        // sistema.criarRestaurante("Rest2", "ruaR2", "Porto", "913", "mail2@a.pt", "userR2", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        //  sistema.criarRestaurante("Rest3", "ruaR3", "Lisboa", "9133", "mail3@aa.com", "userR3", "pass", "pass", 30, 30, 30, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));

//        // todo aqui o metodo fazer preco medio de Restaurante funciona...
//        System.out.println("RESTAURANTES PRECO MEDIO");
        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoACarta("sardinhas", "assadas", 20);
        sistema.getListaRestaurantes().get(0).getEmenta().adicionarPratoAPratosDia("bitoque", "arroz e batatas", 10);

        System.out.println("RESTAURANTES");
        System.out.println(sistema.getListaRestaurantes());
        System.out.println("----------------");

//        System.out.println(sistema.getListaRestaurantes().get(0).getPrecoMedioRestaurante());//ESTE FUNCIONA!
//        System.out.println("-------------------------------------------------------");

//        System.out.println("RESTAURANTES POR FILTROS");
//        System.out.println(sistema.consultarRestaurantePorValores(10,20));
//        System.out.println("-------------------------------------------------------------");

        //  sistema.criarCliente("cli2", "RuaC2", "962", "mailR2@gmail.com", "userC2", "pass", "pass");
        //  sistema.criarCliente("cli3", "RuaC3", "963", "mailR3@gmail.com", "userC3", "pass", "pass");

        //System.out.println("LISTA RESTAURANTES");
        //todo, aqui novamente nao imprime a media dos precos dos pratos
        // System.out.println(sistema.getListaRestaurantes());
        // System.out.println("---------------------");

        //todo, criar ReservaPresencial - n funciona
//        sistema.login("userC1","pass");
//        sistema.getClienteAtivo().criarReservaPresencial(sistema.getListaRestaurantes().get(0), new GregorianCalendar(2021,1,5),
//                LocalTime.of(13,0), 1,20);

//        System.out.println("RESERVA");
//       System.out.println(sistema.getListaClientes().get(0).getListaReservas());
//       System.out.println("-----------------------------------------------------");


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
