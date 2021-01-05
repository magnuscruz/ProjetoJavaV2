package com.company;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Comentario implements Serializable {
    private static int idEstaticoComentario = 1;
    private int idComentario;
    private String opiniao;
    private double pontuacao;
    private Cliente cliente;
    private Restaurante restaurante;
    private GregorianCalendar dataComentario = new GregorianCalendar();
    private boolean status;
    private int ano;
    private int mes;
    private int dia;

    public Comentario(String opiniao, double pontuacao, Cliente cliente, Restaurante restaurante) {
        this.idComentario = idEstaticoComentario++;
        this.opiniao = opiniao;
        this.pontuacao = pontuacao;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.status = true;

        this.dataComentario.toInstant();//Automaticamente fica a data do dia que foi feito o Comentario!
        this.ano = dataComentario.get(Calendar.YEAR);
        this.mes = dataComentario.get((Calendar.MONTH));
        this.dia = dataComentario.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return "\niD " + idComentario +
                " descricao='" + opiniao + '\'' +
                ", pontuacao=" + pontuacao +
                ", cliente=" + cliente +
                ", restaurante=" + restaurante +
                ", data=" + dia + "/" + (mes + 1) + "/" + ano +
                '}';
    }

    public GregorianCalendar getDataComentario() {
        return dataComentario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOpiniao() {
        return opiniao;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setOpiniao(String opiniao) {
        this.opiniao = opiniao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public double getIdComentario (){
        return idComentario;
    }
}