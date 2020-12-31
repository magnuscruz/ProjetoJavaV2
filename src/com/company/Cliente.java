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

    //todo NAO FIZ COMMIT
    public int restauranteAberto(LocalTime hora) {
        // Indice dos returns possiveis: 0 - fechado | 1 - aberto Almoco | 2 - aberto Jantar//

        //LocalTime horaEscolhida = LocalTime.of(hora, minuto);// Como tinha anteriormente, mudei por causa dos parametros do metodo, nao testei
        LocalTime horaEscolhida = LocalTime.of(hora.getHour(), hora.getMinute());

        LocalTime aberturaAlm = restaurante.getInicioAlm();
        LocalTime fechoAlm = restaurante.getFimAlm();
        LocalTime aberturaJan = restaurante.getInicioJan();
        LocalTime fechoJan = restaurante.getFimJan();

        if (horaEscolhida.isAfter(aberturaAlm) && horaEscolhida.isBefore(fechoAlm)) {
            return 1;
        }
        if (horaEscolhida.isAfter(aberturaJan) && horaEscolhida.isBefore(fechoJan)) {
            return 2;

        } else return 0;
    }

    public boolean validarData (GregorianCalendar data){
        boolean dataValida = false;
        GregorianCalendar ontem = new GregorianCalendar();
        ontem.toInstant();
        ontem.add(GregorianCalendar.DAY_OF_MONTH,-1);

        if (data.after(ontem.toInstant())){
            dataValida = true;
        }
        return dataValida;
    }

    public int criarReservaPresencial(Restaurante r, GregorianCalendar data, LocalTime hora, int zona, int numLugares) {
//Indice dos returns: 0 - Restaurante fechado! | 1 - Reservado almoco | 2 - Reservado jantar | 3 - sem lugadores disponiveis

        int ano = data.get(Calendar.YEAR);
        switch (restauranteAberto(hora)) //LIMITE-SE A VERIFICAR SE A HORA ESCOLHIDA BATE CERTO COM HORARIO DE ALMOCO (1) OU JANTAR (2)
        {
            //ALMOCO
            case 1 : switch (zona){
                case 1:
            }

                    Presencial p = new Presencial(this, r, data, hora, zona, numLugares);
                    this.getListaReservas().add(p);//adicionamos a lista de reservas do Cliente em especifico
                    r.getListaReservas().add(p);// adicionamos a lista de reservas do Restaurante em especifico
                    // Atencao! Quando criar um metodo para apagar reserva, tenho de apagar nos dois sitios!
                    //Normalmente nao se apagam, deve-se colocar um boolean e dizer que ja nao esta ativa.
                    System.out.println("Criar reserva presencial: " + data + hora);
                    return 1;



            //JANTAR
            case 3: {
                return 2;
            }
            case 0:
                //ESTA FECHADO!!
                return 0;

        }
return 0;
    }

//    public void criarReservaPresencial(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int numeroLugares, int zona) {
//        Presencial p = new Presencial(cliente, restaurante, data, horario, numeroLugares, zona);
//        getListaReservas().add(p);
//    }

    public void criarReservaTakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int quantidade) {
        TakeAway t = new TakeAway(cliente, restaurante, data, horario, quantidade);
        getListaReservas().add(t);
    }

    //todo falta, alem de nao funcionar esta muito incompleto, eu assumo que o primeiro restaurante que apanhar com reserva, faz ai o comentario...
    //todo falta, mesmo a questao da data, nao deixa comentar no proprio dia... verificar se coloco tambem hora exata que fez reserva, tem de ser depois
    public Comentario criarComentarioORIGINAL(String opiniao, double pontuacao, Restaurante restaurante) {
        Calendar diaHoje = Calendar.getInstance();
        for (Reserva r : this.getListaReservas()) {
            if (r.getData().before(diaHoje)) {
                restaurante = r.getRestaurante();
                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
                getListaComentarios().add(comentario);
                return comentario;
            } else System.out.println("Nao pode comentar um restaurante que ainda nao frequentou");
        }
        return null;
    }

    //todo falta - TESTE, TIREI A DATA E OBRIGATORIEDADE DE JA TER RESERVA PARA EVITAR ERROS
    public Comentario criarComentario(String opiniao, double pontuacao, Restaurante restaurante) {
        Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
        getListaComentarios().add(comentario);
        return comentario;
    }

    public ArrayList<Comentario> getListaComentariosClienteX(String nomeCliente) {
        ArrayList<Comentario> listaComentariosClienteX = new ArrayList<>();
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                listaComentariosClienteX.add(c);
            }
        }
        if (listaComentariosClienteX.equals(null)) {
            System.out.println("Cliente " + nomeCliente + " ,nao tem comentarios feitos");
            return null;
        }
        return listaComentariosClienteX;
    }


    //todo falta - verificar pk, a questao da pontuacao depende do valor introduzido na interface... porque ele nao escreve, mas escolhe uma das opcoes
    public void editarComentario(String opiniao, int pontuacao) {
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().equals(this)) {
                if (opiniao != null) {
                    c.setOpiniao(opiniao);
                }
                if (pontuacao < 0) {
                    c.setPontuacao(pontuacao);
                }
            }
        }
    }

    //todo falta - caso tenho mais de um comentario no mesmo restaurante vai eliminar todos...
    public void apagarComentario(Restaurante restaurante) {
        for (Comentario c : getListaComentarios()) {
            if (c.equals(this) && c.getRestaurante().equals(restaurante)) {
                c.setStatus(false);
            }
        }
    }

    public void cancelarReserva() {
        getListaReservas();
        //listaReservas.get(0).setStatus(false);// Algo do genero!
    }

    public ArrayList<Reserva> getListaReservas() {// cada cliente tem as suas proprias reservas
        return this.getListaReservas();
    }

    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

}
