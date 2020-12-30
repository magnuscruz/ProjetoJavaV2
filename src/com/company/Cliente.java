package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente extends Utilizador implements Serializable {
    private static int idCliente = 5000;
    Restaurante restaurante;

    public Cliente(String nome, String morada, String telefone, String email, String username, String password, String confirmarPass) {
        super(nome, morada, telefone, email, username, password, confirmarPass);
        this.id = idCliente++;
        this.status = true;
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
        } else System.out.println("Fechado as: " + hora + "/" + minuto);
        return aberto;
    }

    public ArrayList<Reserva> getListaReservas() {// cada cliente tem as suas proprias reservas
        return this.getListaReservas();
    }

    public String criarReservaPresencial(Restaurante r, GregorianCalendar data, LocalTime hora, int zona, int numLugares) {
        // verificar se restaurante esta aberto senão return false
        int ano = data.get(Calendar.YEAR);
        Presencial p = new Presencial(this, r, data, hora, zona, numLugares);
        this.getListaReservas().add(p);//adicionamos a lista de reservas do Cliente em especifico
        r.getListaReservas().add(p);// adicionamos a lista de reservas do Restaurante em especifico
        // Atencao! Quando criar um metodo para apagar reserva, tenho de apagar nos dois sitios!
        //Normalmente nao se apagam, deve-se colocar um boolean e dizer que ja nao esta ativa.
        System.out.println("Criar reserva presencial: " + data + hora);
        return "";
    }

//    public void criarReservaPresencial(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int numeroLugares, int zona) {
//        Presencial p = new Presencial(cliente, restaurante, data, horario, numeroLugares, zona);
//        getListaReservas().add(p);
//    }


    public Comentario criarComentarioORIGINAL(String opiniao, double pontuacao, Restaurante restaurante) {
        Calendar diaHoje = Calendar.getInstance();
        for (int i = 0; i < this.getListaReservas().size(); i++) {
            if (this.getListaReservas().get(i).getData().before(diaHoje)) {//So quero as reservas com data anterior ao dia de hoje, assim nao permite
                // comentar reservas que ainda nao aconteceram
                restaurante = this.getListaReservas().get(i).getRestaurante();
                // Se tiver mais de um, tem de escolher que restaurante quer
                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
                getListaComentarios().add(comentario);
                return comentario;
            }
            else System.out.println("Nao pode comentar um restaurante que ainda nao experimentou");
        }
        return null;
    }

    //TESTE, TIREI A DATA E OBRIGATORIEDADE DE JA TER RESERVA PARA EVITAR ERROS
    public Comentario criarComentario (String opiniao, double pontuacao, Restaurante restaurante){
                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
                getListaComentarios().add(comentario);
                return comentario;
    }

    public void getListaComentariosClienteX(String nomeCliente) {
        for (int i = 0; i < getListaComentarios().size(); i++) {
            if (nomeCliente.equalsIgnoreCase(getListaComentarios().get(i).getCliente().getNome())) {
                getListaComentarios().get(i);
            }
        }
    }

    public void editarComentario(String opiniao, double pontuacao) {
        for (int i = 0; i < getListaComentarios().size(); i++) {
            if (getListaComentarios().get(i).getCliente().equals(this)) {
                if (opiniao != null) {
                    getListaComentarios().get(i).setOpiniao(opiniao);
                }
                if (pontuacao > 0) {
                    getListaComentarios().get(i).setPontuacao(pontuacao);
                }
            }
        }

    }

    public void apagarComentario() {

        for (int i = 0; i < getListaComentarios().size(); i++) {
            if (getListaComentarios().get(i).getCliente().equals(this)) {
                getListaComentarios().get(i).setStatus(false);
            }
        }
    }


    public void criarReservaTakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int quantidade) {
        TakeAway t = new TakeAway(cliente, restaurante, data, horario, quantidade);
        getListaReservas().add(t);
    }

    public void cancelarReserva() {
        getListaReservas();
        //listaReservas.get(0).setStatus(false);// Algo do genero!
    }


    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

}
