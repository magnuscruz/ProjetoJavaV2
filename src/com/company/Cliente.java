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



//todo falta, alem de nao funcionar esta muito incompleto, eu assumo que o primeiro restaurante que apanhar com reserva, faz ai o comentario...
    //todo falta, mesmo a questao da data, nao deixa comentar no proprio dia... verificar se coloco tambem hora exata que fez reserva, tem de ser depois
    public Comentario criarComentarioORIGINAL(String opiniao, double pontuacao, Restaurante restaurante) {
        Calendar diaHoje = Calendar.getInstance();
        for (Reserva r : this.getListaReservas()){
            if (r.getData().before(diaHoje)){
                restaurante = r.getRestaurante();
                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
                getListaComentarios().add(comentario);
                return comentario;
            }
            else System.out.println("Nao pode comentar um restaurante que ainda nao frequentou");
        }
        return null;
    }

    //todo falta - TESTE, TIREI A DATA E OBRIGATORIEDADE DE JA TER RESERVA PARA EVITAR ERROS
    public Comentario criarComentario (String opiniao, double pontuacao, Restaurante restaurante){
                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
                getListaComentarios().add(comentario);
                return comentario;
    }

    public ArrayList<Comentario> getListaComentariosClienteX(String nomeCliente) {
        ArrayList <Comentario> listaComentariosClienteX = new ArrayList<>();
        for (Comentario c : getListaComentarios()){
            if (c.getCliente().getNome().equalsIgnoreCase(nomeCliente)){
                listaComentariosClienteX.add(c);
            }
        }
        if (listaComentariosClienteX.equals(null)){
            System.out.println("Cliente "+ nomeCliente + " ,nao tem comentarios feitos");
            return null;
        }
        return listaComentariosClienteX;
    }


//todo falta - verificar pk, a questao da pontuacao depende do valor introduzido na interface... porque ele nao escreve, mas escolhe uma das opcoes
    public void editarComentario(String opiniao, int pontuacao) {
        for ( Comentario c : getListaComentarios()){
            if (c.getCliente().equals(this)){
                if (opiniao != null){
                    c.setOpiniao(opiniao);
                }
                if (pontuacao <0){
                    c.setPontuacao(pontuacao);
                }
            }
        }
    }

    //todo falta - caso tenho mais de um comentario no mesmo restaurante vai eliminar todos...
    public void apagarComentario(Restaurante restaurante) {
        for (Comentario c : getListaComentarios()){
            if (c.equals(this) && c.getRestaurante().equals(restaurante)){
                c.setStatus(false);
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
