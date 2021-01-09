package com.company;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Comentario implements Serializable {
    private static int idEstaticoComentario = 1;

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }
    public Integer getIdComentario (){
        return idComentario;
    }
    protected Integer idComentario;
    protected String opiniao;
    protected double pontuacao;
    protected Cliente cliente;
    protected Restaurante restaurante;
    protected GregorianCalendar dataComentario = new GregorianCalendar();
    private boolean status;
    protected int ano;
    protected int mes;
    protected int dia;

    public Comentario(Cliente cliente, Restaurante restaurante) {
        this.idComentario = idEstaticoComentario++;
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
                ", cliente=" + cliente.getNome() +
                ", restaurante=" + restaurante.getNome() +
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

}