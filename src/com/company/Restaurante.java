package com.company;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Restaurante extends Utilizador implements Serializable {
    // private static int idRestaurante = 1;
    private int id;
    private String cidade;
    private int lotacaoEsplanada;
    private int lotacaoNFum;
    private int lotacaoFum;
    private LocalTime inicioAlm;
    private LocalTime fimAlm;
    private LocalTime inicioJan;
    private LocalTime fimJan;
    // private double precoMedio;
    // private double pontuacaoMedia;
    private Ementa ementa;


    public Restaurante(String nome, String morada, String cidade, String telefone, String email, String username, String password, String confirmarPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {
        super(nome, morada, telefone, email, username, password, confirmarPass);
        //this.id = idRestaurante++;
        this.cidade = cidade;
        this.lotacaoEsplanada = lotacaoEsplanada;
        this.lotacaoFum = lotacaoFum;
        this.lotacaoNFum = lotacaoNFum;
        this.inicioAlm = inicioAlm;
        this.fimAlm = fimAlm;
        this.inicioJan = inicioJan;
        this.fimJan = fimJan;
        this.ementa = new Ementa();
        this.status = true;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void TESTEENTRARCICLOFOREACHCOMLISTARESERVAS() {
        if (getListaReservas().isEmpty()) {
            System.out.println("ENTROU NO IF DO METODO");
            for (Reserva r : getListaReservas()) {
                if (getListaReservas().isEmpty()) {
                    System.out.println("ENTROU NO FOREACH");
                }
            }
        }
    }

    //TODO : ainda nao funciona correctamente, ou pelo menos nao encaixa no metodo final
    // tem de ter data e hora para verificar se ha vagas
//    public int zonaDisponibilidade(Restaurante restaurante,GregorianCalendar dia, int zona, int num) {
//        //Indice returns: 0 - Sem disponibilidade | 1 - Reserva Confirmada Esplanada | 2 - NFum | 3 - Fum|
//
//       // int disponibilidade = 0;
//        switch (zona) {
//            case 1:
//                System.out.println(getListaReservas().size());
//
//                    for (Reserva r : getListaReservas()) {
//                 //       int disponibilidade = restaurante.getLotacaoEsplanada();
//                        if (r.getRestaurante().getNome().equals(restaurante.getNome()) && r.getData().equals(dia) && r.getStatus()) {
//                           int disponibilidade = r.getRestaurante().lotacaoEsplanada;
//                            System.out.println("ENTROU");
//                            if (disponibilidade >= num) {
//                                r.getRestaurante().lotacaoEsplanada = r.getRestaurante().lotacaoEsplanada - num;
//                                return 1;
//                            }else return 2;
//                        }
//                    }
//
//                }
//                return 1;
//
//
//             //   disponibilidade = lotacaoEsplanada - num;
//                if (disponibilidade >= 0) {
//                    lotacaoEsplanada = disponibilidade;
//                    System.out.println("Reservado!");
//                    JOptionPane.showMessageDialog(null, "Reservado!");
//                    return zona;
//
//                } else {
//                    //TODO : quando tiver tempo colocar lugares disponiveis em formato de String, a frente dos disponiveis
//                    System.out.println("Sem disponibilidade - disponiveis " + lotacaoEsplanada);
//                    JOptionPane.showMessageDialog(null, "Sem disponibilidade - disponiveis: ");
//                }
//                break;
//            case 2:
//                disponibilidade = lotacaoNFum - num;
//                if (disponibilidade >= 0) {
//                    lotacaoNFum = disponibilidade;
//                    System.out.println("Reservado!");
//                    JOptionPane.showMessageDialog(null, "Reservado!");
//                    return zona;
//
//                } else {
//                    System.out.println("Sem disponibilidade - disponiveis: " + lotacaoNFum);
//                    JOptionPane.showMessageDialog(null, "Sem disponibilidade - disponiveis: ");
//                }
//                break;
//            case 3:
//                disponibilidade = lotacaoFum - num;
//                if (disponibilidade >= 0) {
//                    lotacaoFum = disponibilidade;
//                    System.out.println("Reservado!");
//                    JOptionPane.showMessageDialog(null, "Reservado!");
//
//                    return zona;
//
//                } else {
//                    System.out.println("Sem disponibilidade - disponiveis: " + lotacaoFum);
//                    JOptionPane.showMessageDialog(null, "Sem disponibilidade - disponiveis: ");
//                }
//                break;
//        }
//        return 0;
//    }

    @Override
    public String toString() {
        return "\nRestaurante{" + super.toString() +
                "IDNOVO " + getId() +
                " cidade: " + cidade +
                ", lotacaoEsplanada=" + lotacaoEsplanada +
                ", lotacaoFum=" + lotacaoFum +
                ", lotacaoNFum=" + lotacaoNFum +
                ", inicioAlm=" + inicioAlm +
                ", fimAlm=" + fimAlm +
                ", inicioJan=" + inicioJan +
                ", fimJan=" + fimJan +
                ", ementa=" + ementa +
                '}';
    }

    public Ementa getEmenta() {
        return ementa;
    }

    public void setEmenta(Ementa ementa) {
        this.ementa = ementa;
    }

    public ArrayList<Reserva> getListaReservasRestaurante() {
        return restaurante.getListaReservas();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public double getPrecoMedioRestaurante() {
        double countCarta = 0;
        double countDia = 0;
        double precoTotalCarta = 0;
        double precoTotalDia = 0;

        for (Prato p : getEmenta().getCarta()) {
            precoTotalCarta += p.getPreco();
            countCarta++;
        }

        for (Prato p : getEmenta().getPratosDia()) {
            precoTotalDia += p.getPreco();
            countDia++;
        }

//TODO - Confirmar que funciona, devido a questao de comparar a 0
        if ((precoTotalCarta + precoTotalDia) <= 0) {
            return 0;
        }
        return (precoTotalCarta + precoTotalDia) / (countCarta + countDia);
    }

    //TODO - Testar, e verificar se fica aqui ou em Sistema
    public double disponibilidadeRestaurante(Restaurante restaurante, GregorianCalendar dia) {
        double disponibilidade = 0;
        for (Reserva r : getListaReservas()) {
            if (r.getData().equals(dia)) {
                disponibilidade = +r.getRestaurante().getLotacaoEsplanada() + r.getRestaurante().getLotacaoNFum() + r.getRestaurante().getLotacaoFum();
            }
        }
        return disponibilidade;
    }

    public double lotacaoTotalRestaurante (){
        double total = getLotacaoEsplanada()+getLotacaoNFum()+getLotacaoFum();
        return total;
    }

}