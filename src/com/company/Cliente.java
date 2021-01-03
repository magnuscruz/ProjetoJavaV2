package com.company;

import javax.swing.*;
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

    public int restauranteAberto(Restaurante restaurante, LocalTime hora) {
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

    public boolean validarDataSeDataDepoisDaHoraEDataAtual (GregorianCalendar data){
        boolean dataValida = false;
        GregorianCalendar ontem = new GregorianCalendar();
        ontem.toInstant();
        ontem.add(GregorianCalendar.DAY_OF_MONTH,-1);

        if (data.after(ontem.toInstant())){
            dataValida = true;
        }
        return dataValida;
    }

    //TODO INCOMPLETO!!! associar cada reserva a 1 dia e almoco ou jantar.
    public int criarReservaPresencial(Restaurante restaurante, GregorianCalendar data, LocalTime hora, int zona, int numLugares) {
//Indice dos returns: 0 - Restaurante fechado! | 1 - Reservado almoco | 2 - Reservado jantar | 3 - sem lugadores disponiveis

        boolean dataValida = validarDataSeDataDepoisDaHoraEDataAtual(data);

        if (dataValida) {

            switch (restauranteAberto(restaurante, hora)) { //LIMITE-SE A VERIFICAR SE A HORA ESCOLHIDA BATE CERTO COM HORARIO DE ALMOCO (1) OU JANTAR (2)

                //ALMOCO
                case 1:
                    switch (zona) {
                        case 1:
                            int valido = restaurante.zonaDisponibilidade( zona, numLugares);
                            if (valido == 1) {
                                Presencial p = new Presencial(this, restaurante, data, hora, zona, numLugares);
                                getListaReservas().add(p);//adicionamos a lista de reservas do Cliente em especifico
                                restaurante.getListaReservas().add(p);// adicionamos a lista de reservas do Restaurante em especifico
                                // Atencao! Quando criar um metodo para apagar reserva, tenho de apagar nos dois sitios!
                                //Normalmente nao se apagam, deve-se colocar um boolean e dizer que ja nao esta ativa.
                                System.out.println("Criar reserva presencial: " + data + hora);
                                return 1;
                            } else if (valido == 0) {
                                System.out.println("Sem lugares disponiveis");
                            }
                    }

                    //JANTAR
                case 3: {
                    return 2;
                }
                case 0:
                    //ESTA FECHADO!!
                    return 0;

            }
        }
return 0;
    }

    public void criarReservaPresencial2(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int numeroLugares, int zona) {
        Presencial p = new Presencial(this, restaurante, data, horario, numeroLugares, zona);
        restaurante.getListaReservas().add(p);
        boolean res = getListaReservas().add(p);
        if (!res){
            System.out.println("Erro, nao adicionou");
            JOptionPane.showMessageDialog(null, "Erro, não criou");
        }
    }

    public void criarReservaTakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int quantidade) {
        TakeAway t = new TakeAway(cliente, restaurante, data, horario, quantidade);
        getListaReservas().add(t);
    }

   //todo  (prof nao) incompleto
    public Comentario criarComentarioORIGINAL(String opiniao, double pontuacao, Restaurante restaurante) {
        Calendar diaHoje = Calendar.getInstance();
        for (Reserva r : this.getListaReservas()) {
            if (r.getData().before(diaHoje)) {
                restaurante = r.getRestaurante();
                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
                getListaComentarios().add(comentario);
                JOptionPane.showMessageDialog(null, "Obrigado pela sua opinião");
                return comentario;
            } else System.out.println("Nao pode comentar um restaurante que ainda nao frequentou");
        }
        return null;
    }
    //TODO (prof nao) este criarComentario funciona, mas ver o de cima, é o original!//Nao esquecer como reserva nao funciona, nao da p testar 100%
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
            JOptionPane.showMessageDialog(null, "Cliente "+ nomeCliente + " não tem comentarios feitos");
            System.out.println("Cliente " + nomeCliente + " ,nao tem comentarios feitos");
            return null;
        }
        return listaComentariosClienteX;
    }

    public void editarComentario(String opiniao, int pontuacao) {
        //TODO
        // Confirmar que tipo de campo é que recebemos da interface, se é int ou string ou outra coisa qualquer...
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().equals(this)) {
                if (opiniao != null) {
                    c.setOpiniao(opiniao);
                }
                if (pontuacao <= 0 ) {
                    c.setPontuacao(pontuacao);
                }
            }
        }
    }

    //TODO falta - caso tenho mais de um comentario no mesmo restaurante vai eliminar todos...
    public void apagarComentario(Restaurante restaurante) {
        for (Comentario c : getListaComentarios()) {
            if (c.equals(this) && c.getRestaurante().equals(restaurante)) {
                c.setStatus(false);
            }
        }
    }

    public void cancelarReserva (Cliente this) {
        getListaReservas();

        for(Reserva r: getListaReservas()){
            if (r.getCliente().equals(this)){
                r.setStatus(false);
                //TODO : como Cliente e Restaurante têm lista de reservas,
                //tambem tenho de por em Restaurante set.Status (false)
                // nao estou a ver como...
                JOptionPane.showMessageDialog(null, "Reserva cancelada");
            }
        }
    }


    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }

}
