package com.company;

import java.io.Serializable;
import java.time.LocalTime;

public class Restaurante extends Utilizador implements Serializable {
    private static int idRestaurante=1;


    private int lotacaoEsplanada;
    private int lotacaoFum;
    private int lotacaoNFum;
    private LocalTime inicioHorarioAlm;
    private LocalTime fimHorarioAlm;
    private LocalTime inicioHorarioJan;
    private LocalTime fimHorarioJan;
    private double pontuacaoMedia;
    private int horaInicioAlm;
    private int minInicioAlm;
    private int horaFimAlm;
    private int minFimAlm;
    private int horaInicioJan;
    private int minInicioJan;
    private int horaFimJan;
    private int minFimJan;

    Restaurante(){}

    public Restaurante(String nome, String morada, String telefone, String email, String username, String password, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, int horaInicioAlm, int minInicioAlm, int horaFimAlm, int minFimAlm, int horaInicioJan, int minInicioJan, int horaFimJan, int minFimJan) {
        super(nome, morada, telefone, email, username,password);
        this.id = idRestaurante++;
        this.lotacaoEsplanada = lotacaoEsplanada;
        this.lotacaoFum = lotacaoFum;
        this.lotacaoNFum = lotacaoNFum;
        this.inicioHorarioAlm = LocalTime.of(horaInicioAlm, minInicioAlm);
        this.fimHorarioAlm = LocalTime.of(horaFimAlm, minFimAlm);
        this.inicioHorarioJan = LocalTime.of(horaInicioJan, minInicioJan);
        this.fimHorarioJan = LocalTime.of(horaFimJan, minFimJan);
        //this.pontuacaoMedio = pontuacao;

    }

    @Override
    public String toString() {
        return "\nRestaurante: " +  super.toString() +
                "lotacaoEsplanada=" + lotacaoEsplanada +
                ", lotacaoFum=" + lotacaoFum +
                ", lotacaoNFum=" + lotacaoNFum +
                ", inicioHorarioAlm=" + inicioHorarioAlm +
                ", fimHorarioAlm=" + fimHorarioAlm +
                ", inicioHorarioJan=" + inicioHorarioJan +
                ", fimHorarioJan=" + fimHorarioJan +
                ", pontuacaoMedia=" + pontuacaoMedia +
                "} ";
    }

    public String toStringComentarios  (){
        return "Nome: " + nome;
    }

    public LocalTime getInicioHorarioAlm() {
        return inicioHorarioAlm;
    }

    public void setInicioHorarioAlm(LocalTime inicioHorarioAlm) {
        this.inicioHorarioAlm = inicioHorarioAlm;
    }

    public LocalTime getFimHorarioAlm() {
        return fimHorarioAlm;
    }

    public void setFimHorarioAlm(LocalTime fimHorarioAlm) {
        this.fimHorarioAlm = fimHorarioAlm;
    }

    public LocalTime getInicioHorarioJan() {
        return inicioHorarioJan;
    }

    public void setInicioHorarioJan(LocalTime inicioHorarioJan) {
        this.inicioHorarioJan = inicioHorarioJan;
    }

    public LocalTime getFimHorarioJan() {
        return fimHorarioJan;
    }

    public void setFimHorarioJan(LocalTime fimHorarioJan) {
        this.fimHorarioJan = fimHorarioJan;
    }
}
