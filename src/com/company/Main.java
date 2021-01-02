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






        sistema.criarRestaurante("Rest1", "ruaR2", "Coimbra", "961876453", "MAIL1@a.pt", "userR1", "pass", "pass", 20, 20, 20, LocalTime.of(11, 30), LocalTime.of(15, 00), LocalTime.of(18, 30), LocalTime.of(22, 00));
        sistema.criarRestaurante("Rest2", "ruaR2", "Coimbra", "961876454", "MAIL2@a.pt", "userR2", "pass", "pass", 10, 20, 20, LocalTime.of(12, 30), LocalTime.of(15, 00), LocalTime.of(20, 30), LocalTime.of(23, 59));
        sistema.criarRestaurante("Rest3", "ruaR2", "Coimbra", "961876455", "MAIL3@a.pt", "userR3", "pass", "pass", 20, 20, 20, LocalTime.of(13, 30), LocalTime.of(15, 00), LocalTime.of(21, 30), LocalTime.of(23, 59));

        sistema.criarCliente("A", "Rua x", "888888888", "ee@mm.pt", "user","345678", "345678");

//        sistema.getClienteAtivo().criarReservaPresencial2(sistema.getClienteAtivo(), sistema.getListaRestaurantes().get(0), new GregorianCalendar(2021, 03, 01),
//                LocalTime.of(13, 00), 1, 5);
//        System.out.println("Lista RESERVAS");
//
//        System.out.println(sistema.getClienteAtivo().getListaReservas());


        System.out.println("------------");
        System.out.println("RESTAURANTES");
        System.out.println(sistema.getListaRestaurantes());
        System.out.println("----------------");


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
      //  sistema.gravarSistema();


        ArrayList <Restaurante> listaRestau = sistema.getListaRestaurantes();
        for(Restaurante r: listaRestau){
            //funcao da interfacegrafica que adiciona uma linha à tabela
            r.getNome();//Para meter em cada campo da tabela o tipo especifico que queremos
        }



        Interface sistemaGrafico = new Interface(sistema);
        sistemaGrafico.setVisible(true);
    }
}
