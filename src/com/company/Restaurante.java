package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public class Restaurante extends Utilizador implements Serializable {
    private static int idRestaurante=1;

    private int lotacaoEsplanada;
    private int lotacaoFum;
    private int lotacaoNFum;
    private LocalTime inicioAlm;
    private LocalTime fimAlm;
    private LocalTime inicioJan;
    private LocalTime fimJan;
    private double pontuacaoMedia;
    private Ementa ementa;

    public Restaurante(String nome, String morada, String telefone, String email, String username, String password, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {
        super(nome, morada, telefone, email, username,password);
        this.id = idRestaurante++;
        this.lotacaoEsplanada = lotacaoEsplanada;
        this.lotacaoFum = lotacaoFum;
        this.lotacaoNFum = lotacaoNFum;
        this.inicioAlm =inicioAlm;
        this.fimAlm = fimAlm;
        this.inicioJan = inicioJan;
        this.fimJan = fimJan;
        this.pontuacaoMedia = getPontuacaoMedia();//VERIFICAR SE METODO FUNCIONA
        this.ementa = getEmenta();

//        this.inicioHorarioAlm = LocalTime.of(horaInicioAlm, minInicioAlm);
//        this.fimHorarioAlm = LocalTime.of(horaFimAlm, minFimAlm);
//        this.inicioHorarioJan = LocalTime.of(horaInicioJan, minInicioJan);
//        this.fimHorarioJan = LocalTime.of(horaFimJan, minFimJan);

    }

    @Override
    public String toString() {
        return "\nRestaurante{" + super.toString() +
                "lotacaoEsplanada=" + lotacaoEsplanada +
                ", lotacaoFum=" + lotacaoFum +
                ", lotacaoNFum=" + lotacaoNFum +
                ", inicioAlm=" + inicioAlm +
                ", fimAlm=" + fimAlm +
                ", inicioJan=" + inicioJan +
                ", fimJan=" + fimJan +
                ", pontuacaoMedia=" + pontuacaoMedia +
                '}';
    }

    public Ementa getEmenta() {
        return ementa;
    }

    public void setEmenta(Ementa ementa) {

        this.ementa = ementa;
    }

    public ArrayList<Reserva> getListaReservas(){
        return this.listaReservas;
    }

    public int getLotacaoEsplanada() {
        return lotacaoEsplanada;
    }

    public void setLotacaoEsplanada(int lotacaoEsplanada) {
        this.lotacaoEsplanada = lotacaoEsplanada;
    }

    public int getLotacaoFum() {
        return lotacaoFum;
    }

    public void setLotacaoFum(int lotacaoFum) {
        this.lotacaoFum = lotacaoFum;
    }

    public int getLotacaoNFum() {
        return lotacaoNFum;
    }

    public void setLotacaoNFum(int lotacaoNFum) {
        this.lotacaoNFum = lotacaoNFum;
    }

    public LocalTime getInicioAlm() {
        return inicioAlm;
    }

    public void setInicioAlm(LocalTime inicioAlm) {
        this.inicioAlm = inicioAlm;
    }

    public LocalTime getFimAlm() {
        return fimAlm;
    }

    public void setFimAlm(LocalTime fimAlm) {
        this.fimAlm = fimAlm;
    }

    public LocalTime getInicioJan() {
        return inicioJan;
    }

    public void setInicioJan(LocalTime inicioJan) {
        this.inicioJan = inicioJan;
    }

    public LocalTime getFimJan() {
        return fimJan;
    }

    public void setFimJan(LocalTime fimJan) {
        this.fimJan = fimJan;
    }



    public double getPontuacaoMedia() {
        double count=0;
        double totalPontuacao = 0;
        for (int i = 0; i < listaComentarios.size(); i++) {
            if (listaComentarios.get(i).getRestaurante().equals(this)){
                count++;
                totalPontuacao += listaComentarios.get(i).getPontuacao();
            }
        }
        return pontuacaoMedia = totalPontuacao/count;
    }


}
