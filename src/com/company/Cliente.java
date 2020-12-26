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

    public ArrayList<Reserva> getListaReservas() {// cada cliente tem as suas proprias reservas
        return this.listaReservas;
    }

    public String criarReservaPresencial(Restaurante r, GregorianCalendar data, LocalTime hora) {
        // verificar se restaurante esta aberto senão return false
        int ano = data.get(Calendar.YEAR);
        Presencial p = new Presencial(this, r, data, hora, 1, 5);
        this.listaReservas.add(p);//adicionamos a lista de reservas do Cliente em especifico
        r.listaReservas.add(p);// adicionamos a lista de reservas do Restaurante em especifico
        // Atencao! Quando criar um metodo para apagar reserva, tenho de apagar nos dois sitios!
        //Normalmente nao se apagam, deve-se colocar um boolean e dizer que ja nao esta ativa.
        System.out.println("Criar reserva presencial: " + data + hora);
        return "";
    }

    public void criarComentario(String opiniao, double pontuacao, Restaurante restaurante) {

        LocalTime diaHoje = LocalTime.now();
        for (int i = 0; i < this.listaReservas.size(); i++) {
            if (this.listaReservas.get(i).getData().before(diaHoje))//So quero as reservas com data anterior ao dia de hoje, assim nao permite
                // comentar reservas que ainda nao aconteceram
                this.listaReservas.get(i).getRestaurante();
            // Se tiver mais de um, tem de escolher que restaurante quer
            Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
            listaComentarios.add(comentario);
        }
    }

    public void getListaComentariosClienteX(String nomeCliente) {
        for (int i = 0; i < listaComentarios.size(); i++) {
            if (nomeCliente.equalsIgnoreCase(listaComentarios.get(i).getCliente().getNome())) {
                listaComentarios.get(i);
            }
        }
    }

    public void editarComentario(String opiniao, double pontuacao) {
        getListaComentarios();//Nao tenho a certeza se assim apresenta a lista de reservas efetuadas pelo Cliente
        for (int i = 0; i < this.listaComentarios.size(); i++) {

        }
    }

    public void apagarComentario() {
        getListaComentarios();

        //getListaComentarios().get(i).setStatus(false);// Creio que a solucao mais simples deve ser algo do genero :X
    }


    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

}
