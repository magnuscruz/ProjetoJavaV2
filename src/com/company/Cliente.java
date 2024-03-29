package com.company;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente extends Utilizador implements Serializable {
    // private static int idCliente = 5000;
    Restaurante restaurante;

    public Cliente(String nome, String morada, String telefone, String email, String username, String password, String confirmarPass) {
        super(nome, morada, telefone, email, username, password, confirmarPass);
        //this.id = idCliente++;
        this.status = true;
    }

    //TODO incompleto!!
    public boolean dataStringParaGregorian (String hora){

        boolean valido = false;
        for (int i = 0; i < hora.length(); i++) {
            Character caractere = hora.charAt(i);
            if (Character.isDigit(caractere) || hora.charAt(i)==3) {
                valido = true;
            } else {
                valido = false;
                break;
            }
        }
        return valido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean validarDataHoraDeReserva(GregorianCalendar data, LocalTime horas) {
        GregorianCalendar dataNesteMomento = new GregorianCalendar();
        dataNesteMomento.toInstant();

        int ano = data.get(Calendar.YEAR);
        int mes = data.get(Calendar.MONTH);
        int dia = data.get(Calendar.DAY_OF_MONTH);

        int hora = horas.getHour();
        int minuto = horas.getMinute();

        GregorianCalendar dataHoraDaReserva = new GregorianCalendar(ano, mes, dia, hora, minuto);
        boolean valido = dataHoraDaReserva.after(dataNesteMomento);

        if (valido) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Insira uma data e hora posterior ao dia de hoje!");
        return false;
    }

    public int restauranteAberto(Restaurante restaurante, LocalTime hora) {
        // Indice dos returns possiveis: 0 - fechado | 1 - aberto Almoco | 2 - aberto Jantar//

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

        } else {
            JOptionPane.showMessageDialog(null, "Restaurante fechado - Escolha outra hora");
            return 0;
        }
    }
//Comentei esta parte do código do Adriano para voltar a funcionar
    //TODO INCOMPLETO!!! associar cada reserva a 1 dia e almoco ou jantar.
//    public int criarReservaPresencial(Restaurante restaurante, GregorianCalendar data, LocalTime hora, int zona, int numLugares) {
////Indice dos returns: 0 - Restaurante fechado! | 1 - Reservado almoco | 2 - Reservado jantar | 3 - sem lugadores disponiveis
//
//        boolean dataValida = validarDataHoraDeReserva(data, hora);
//
//        if (dataValida) {
//
//            switch (restauranteAberto(restaurante, hora)) { // HORARIO DE ALMOCO (1) OU JANTAR (2)
//
//                //Reserva para almoco
//                case 1:
//                    switch (zona) {//DENTRO DO ALMOCO - ESCOLHER EM QUE ZONA DO RESTAURANTE QUER RESERVAR!
//                        case 1:
//                            int valido = restaurante.zonaDisponibilidade(restaurante,data, zona, numLugares);
//                            if (valido == 1) {
//                                Presencial p = new Presencial(cliente, restaurante, data, hora, zona, numLugares);
//                                getListaReservas().add(p);//adicionamos a lista de reservas do Cliente em especifico
//                                //  restaurante.getListaReservas().add(p);// adicionamos a lista de reservas do Restaurante em especifico
//                                // Atencao! Quando criar um metodo para apagar reserva, tenho de apagar nos dois sitios!
//                                //Normalmente nao se apagam, deve-se colocar um boolean e dizer que ja nao esta ativa.
//                                JOptionPane.showMessageDialog(null, "Reservado!");
//                                //  System.out.println("Criar reserva presencial: " + data + hora);
//                                return 1;
//
//                            } else if (valido == 0) {
//                                System.out.println("Sem lugares disponiveis");
//                            }
//                    }
//
//                    //Reservar para jantar
//                case 3: {
//                    return 2;
//                }
//                case 0:
//                    //ESTA FECHADO!!
//                    return 0;
//
//            }
//        }
//        return 0;
//    }

//    public void criarReservaPresencial2(Restaurante restaurante, GregorianCalendar data, LocalTime horario, int numeroLugares, int zona) {
//        Presencial p = new Presencial(this, restaurante, data, horario, numeroLugares, zona);
//        restaurante.getListaReservas().add(p);
//        boolean res = getListaReservas().add(p);
//        if (!res) {
//            System.out.println("Erro, nao adicionou");
//            JOptionPane.showMessageDialog(null, "Erro, não criou");
//        }
//    }

    //TODO  - só permite que take away seja 30 % de lotacao
    public boolean validarQtdRefeicoesPedidas(int quantidade, Restaurante restaurante) {
        double max = restaurante.lotacaoTotalRestaurante()*0.3;
        //  int qtdMax = 21;
        if (quantidade >= max) {
            JOptionPane.showMessageDialog(null, "Limite máximo por pedido é " + max);
            return false;
        }
        return true;
    }

    public boolean validarSeRestauranteTemEmenta(Restaurante r) {
        if (r.getEmenta().getCarta().isEmpty() && r.getEmenta().getPratosDia().isEmpty()) {
            return false;
        }
        return true;
    }

    public void criarReservaTakeAway(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime horario, int quantidade, int cartaOuPratoDoDia, int indexPrato) {
        boolean validarDatas = validarDataHoraDeReserva(data, horario);
        int restauranteAberto = restauranteAberto(restaurante, horario);
        boolean validarQtdRefeicoes = validarQtdRefeicoesPedidas(quantidade, restaurante);

        if (validarDatas) {
            if (restauranteAberto == 1 || restauranteAberto == 2) {
                if (validarQtdRefeicoes) {
                    if (cartaOuPratoDoDia == 1) {
                        TakeAway t = new TakeAway(cliente, restaurante, data, horario, quantidade);
                        t.setPrato(restaurante.getEmenta().getCarta().get(indexPrato));
                        //getListaReservas().add(t);
                    } else {
                        TakeAway t = new TakeAway(cliente, restaurante, data, horario, quantidade);
                        t.setPrato(restaurante.getEmenta().getPratosDia().get(indexPrato));
                        //getListaReservas().add(t);
                    }

                }
            }
        }
    }

    public void editarReservaTakeAway(Restaurante restaurante, GregorianCalendar data, LocalTime horario, int quantidade) {
        boolean validarDatas = validarDataHoraDeReserva(data, horario);
        boolean validarQtdRefeicoes = validarQtdRefeicoesPedidas(quantidade, restaurante);

        if (validarDatas) {
            if (validarQtdRefeicoes) {
                TakeAway t = new TakeAway(cliente, restaurante, data, horario, quantidade);
                //getListaReservas().add(t);
            }
        }
    }

    public void editarReservaPresencial(GregorianCalendar data, LocalTime hora, int zona, int numLugares) {

    }

//    public void cancelarReserva(Reserva reserva) {
//
//        for (Reserva r : getListaReservas()) {
//            if (r instanceof TakeAway && r.getIdReserva() == reserva.getIdReserva()) {
//                r.setStatus(false);
//            } else {
//                r.setStatus(false);
//            }
//        }
//    }


    @Override
    public String toString() {
        return "\nCliente: " + super.toString();
    }
}