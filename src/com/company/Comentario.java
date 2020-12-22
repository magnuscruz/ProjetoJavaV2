package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Comentario implements Serializable {
    private String opniao;
    private double pontuacao;
    //private Cliente cliente;
   // private Restaurante restaurante;
    private String cliente;
    private String restaurante;
    private GregorianCalendar dataHoje;
    int ano;
    int mes;
    int dia;




    public Comentario(String opniao, double pontuacao, String cliente, String restaurante) {//Nao faz sentido o comentario pedir a data.
        // ou fica a data do dia que foi feito, ou entao usa a da reserva!
        this.opniao = opniao;
        this.pontuacao = pontuacao;
        this.cliente = cliente;
        this.restaurante = restaurante;

        Calendar dataHoje = Calendar.getInstance();//Automaticamente fica a data do dia que foi feito o Comentario!
        this.ano = dataHoje.get(Calendar.YEAR);
        this.mes = dataHoje.get((Calendar.MONTH));
        this.dia = dataHoje.get(Calendar.DAY_OF_MONTH);
    }


    @Override
    public String toString() {
        return "Comentario{" +
                "descricao='" + opniao + '\'' +
                ", pontuacao=" + pontuacao +
                ", cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" +  dia +"/" + (mes+1) + "/" + ano +
                '}';
    }
}
