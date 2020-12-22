package com.company;

import java.io.Serializable;
import java.time.LocalTime;

public class Cliente extends Utilizador implements Serializable {
    private static int idCliente = 5000;
    Restaurante restaurante;

    public Cliente(String nome, String morada, String telefone, String email, String username, String password) {
        super(nome, morada, telefone, email, username, password);
        this.id = idCliente++;
    }

    Cliente(){
        this.restaurante=new Restaurante();
    }

    public boolean restauranteAberto(int hora, int minuto){
        boolean aberto=false;
        LocalTime horaEscolhida = LocalTime.of(hora, minuto);
        LocalTime aberturaAlm = restaurante.getInicioHorarioAlm();
        LocalTime fechoAlm = restaurante.getFimHorarioAlm();
        LocalTime aberturaJan = restaurante.getInicioHorarioJan();
        LocalTime fechoJan = restaurante.getFimHorarioJan();
        if (horaEscolhida.isBefore(aberturaAlm) && horaEscolhida.isAfter(fechoAlm)  || horaEscolhida.isBefore(aberturaJan) && horaEscolhida.isAfter(fechoJan)){
            aberto=true;
        }
        return aberto;
    }

    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

    public String Comentarios (){
        return "nome: "+ nome;
    }

}
