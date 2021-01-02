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


//        sistema.getClienteAtivo().criarReservaPresencial2(sistema.getClienteAtivo(), sistema.getListaRestaurantes().get(0), new GregorianCalendar(2021, 03, 01),
//                LocalTime.of(13, 00), 1, 5);
//        System.out.println("Lista RESERVAS");
//
//        System.out.println(sistema.getClienteAtivo().getListaReservas());


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



        Interface sistemaGrafico = new Interface(sistema);
        sistemaGrafico.setVisible(true);
    }
}
