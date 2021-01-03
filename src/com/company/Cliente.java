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

    public boolean validarDataHoraDeReserva (GregorianCalendar data, LocalTime horas) {
        GregorianCalendar dataNesteMomento = new GregorianCalendar();
        dataNesteMomento.toInstant();

        int ano = data.get(Calendar.YEAR);
        int mes = data.get(Calendar.MONTH);
        int dia = data.get(Calendar.DAY_OF_MONTH);

        int hora = horas.getHour();
        int minuto = horas.getMinute();

        GregorianCalendar dataHoraDaReserva = new GregorianCalendar(ano, mes, dia, hora, minuto);
        boolean valido = dataHoraDaReserva.after(dataNesteMomento);

        if (valido){
            return true;
        }
        return false;
    }

    //TODO INCOMPLETO!!! associar cada reserva a 1 dia e almoco ou jantar.
    public int criarReservaPresencial(Restaurante restaurante, GregorianCalendar data, LocalTime hora, int zona, int numLugares) {
//Indice dos returns: 0 - Restaurante fechado! | 1 - Reservado almoco | 2 - Reservado jantar | 3 - sem lugadores disponiveis

        boolean dataValida = validarDataHoraDeReserva(data, hora);

        if (dataValida) {

            switch (restauranteAberto(restaurante, hora)) { //LIMITE-SE A VERIFICAR SE A HORA ESCOLHIDA BATE CERTO COM HORARIO DE ALMOCO (1) OU JANTAR (2)

                //Reserva para almoco
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

                    //Reservar para jantar
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

    public void cancelarReserva () {
        getListaReservas();

        for(Reserva r: getListaReservas()){
            if (r.getCliente().getNome().equals(this.nome)){
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
