package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente extends Utilizador implements Serializable {
    private static int idCliente = 5000;
    Restaurante restaurante;

    public Cliente(String nome, String morada, String telefone, String email, String username, String password) {
        super(nome, morada, telefone, email, username, password);
        this.id = idCliente++;
    }

    public boolean restauranteAberto(int hora, int minuto) {
        boolean aberto = false;
        LocalTime horaEscolhida = LocalTime.of(hora, minuto);
        LocalTime aberturaAlm = restaurante.getInicioAlm();
        LocalTime fechoAlm = restaurante.getFimAlm();
        LocalTime aberturaJan = restaurante.getInicioJan();
        LocalTime fechoJan = restaurante.getFimJan();
        if (horaEscolhida.isBefore(aberturaAlm) && horaEscolhida.isAfter(fechoAlm) || horaEscolhida.isBefore(aberturaJan) && horaEscolhida.isAfter(fechoJan)) {
            aberto = true;
        }
        return aberto;
    }

    public String criarReservaPresencial(Restaurante r, GregorianCalendar data, LocalTime hora) {
        // verificar se restaurante esta aberto senão return false
        int  ano = data.get(Calendar.YEAR);
        Presencial p = new Presencial(this,r,ano,5,1,5,3, 3,5);
        this.listaReservas.add(p);//adicionamos a lista de reservas do Cliente em especifico
        r.listaReservas.add(p);// adicionamos a lista de reservas do Restaurante em especifico
        // Atencao! Quando criar um metodo para apagar reserva, tenho de apagar nos dois sitios!
        //Normalmente nao se apagam, deve-se colocar um boolean e dizer que ja nao esta ativa.
        System.out.println("Criar reserva presencial: "+ data + hora);
        return "";
    }

    public ArrayList<Reserva> getListaReservas (){// cada cliente tem as suas proprias reservas
        return this.listaReservas;
    }

    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

}
