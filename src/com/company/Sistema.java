package com.company;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sistema implements Serializable {
    private ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    private ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private Utilizador utilizarAtivo;

    public Sistema() {
        try {
            FicheiroDeObjectos ficheiroOb = new FicheiroDeObjectos();
            ficheiroOb.abreLeitura("FicheiroProjeto.dat");

            try {
                Sistema sistema = (Sistema) ficheiroOb.leObjecto();
                ficheiroOb.fechaLeitura();
                listaComentarios = sistema.listaComentarios;
                listaUtilizadores = sistema.listaUtilizadores;
            } catch (Exception e) {
                System.out.println("EXCEPCAO: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("EXCEPCAO: " + e.getMessage());
        }
    }

    public boolean gravarSistema() {

        try {
            FicheiroDeObjectos ficheiroOb = new FicheiroDeObjectos();
            ficheiroOb.abreEscrita("FicheiroProjeto.dat");
            ficheiroOb.escreveObjecto(this);
            ficheiroOb.fechaEscrita();
            System.out.println("Sistema gravado com sucesso");

        } catch (Exception e) {
            System.out.println("EXCEPCAO: " + e.getMessage());
        }
        return true;
    }

    private Utilizador getUtilizarAtivo() {
        return this.utilizarAtivo;
    }

    public Cliente getClienteAtivo() {
        if (getUtilizarAtivo() instanceof Cliente) {
            return (Cliente) getUtilizarAtivo();
        }
        return null;
    }

    public Restaurante getRestauranteAtivo() {
        if (getUtilizarAtivo() instanceof Restaurante) {
            return (Restaurante) getUtilizarAtivo();
        }
        return null;
    }

    public ArrayList<Utilizador> getListaUtilizadores() {
        return listaUtilizadores;
    }

    public ArrayList<Restaurante> getListaRestaurantes() {
        //SO APARECEM OS RESTAURANTES COM STATUS =  TRUE!!
        ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
        for (Utilizador u : listaUtilizadores) {
            if (u.getStatus() && u instanceof Restaurante) {
                listaRestaurantes.add((Restaurante) u);
            }
        }
        return listaRestaurantes;
    }

    public ArrayList<Cliente> getListaClientes() {
        //ATENCAO: SO APARECEM CLIENTES COM STATUS = TRUE!!!
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        int i = 0;
        for (Utilizador u : listaUtilizadores) {
            if (u.getStatus() && u instanceof Cliente) {
                listaClientes.add((Cliente) u);
            }
        }
        return listaClientes;
    }

    public void utilizadorExiste(String username) {
        boolean existe = false;
        for (Utilizador u : listaUtilizadores) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                String nomeClasse = u.getClass().getSimpleName();// Imprime o nome da Classe. Tem é de se associar a uma variavel
                System.out.println("Utilizador com o username: " + u.getUsername() + "é do tipo: " + nomeClasse);
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("Nao existe");
        }
    }

    public Utilizador login(String username, String pass) {
        boolean valido = false;

        for (Utilizador u : listaUtilizadores) {
            if (username.equals(u.getUsername()) && pass.equals(u.getPassword())) {
                this.utilizarAtivo = u;
                return u;
            }
        }
        return null;
    }

    public boolean validarString(String texto) {
        boolean valido = false;

        for (int i = 0; i < texto.length(); i++) {
            Character caractere = texto.charAt(i);
            if (Character.isAlphabetic(caractere)) {
                valido = true;
            } else {
                valido = false;
                break;
            }
        }
        return valido;
    }

    private boolean emailUnico(String email) {
        boolean unico = true;
        for (Utilizador s : listaUtilizadores) {
            if (email.equalsIgnoreCase(s.getEmail())) {
                unico = false;
            }
        }
        return unico;
    }

    private boolean validarEmail(String email) {
        boolean mailValido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                mailValido = true;
            }
        }
        return mailValido;
    }

    private boolean usernameUnico(String username) {
        boolean unico = true;

        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (username.equalsIgnoreCase(listaUtilizadores.get(i).getUsername())) {
                unico = false;
            }
        }
        return unico;
    }

    private boolean confirmarPass(String pass1, String pass2) {
        boolean correta = false;
        if (pass1.equals(pass2)) {
            correta = true;
            return correta;
        }
        return correta;
    }

    //todo caso a hora seja depois das 24 da uma excecao. coloco esse controlo de excecao neste metodo ou dentro do criarRestaurante?
    //ESTA MUITO INCOMPLETO!!!
    private boolean validarHorario(LocalTime inicioAlm) {
        boolean valido = true;

        if (inicioAlm.getHour() > 23 || inicioAlm.getMinute() > 59) {
            valido = false;
        }
        return valido;
    }

    private boolean telefoneUnico(String telefone) {
        boolean unico = true;

        for (Utilizador u : listaUtilizadores) {
            if (u.getStatus() && u.getTelefone().equals(telefone)) {
                unico = false;
            }
        }
        return unico;
    }

    //todo Muito basico, só valida se foram introduzidos 9 numeros
    private boolean validarTelefone(String num) {
        int count = 0;
        char[] c;
        boolean a = false;
        c = num.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                count++;
                a = true;
            } else {
                a = false;
                break;
            }
        }
        if (a && count == 9) {
        } else {
            a = false;
        }
        return a;
    }

    private boolean validarLotacao(int lot1, int lot2, int lot3) {
        boolean validar = false;

        if ((lot1 < 101 && lot1 >= 0) && (lot2 < 101 && lot2 >= 0) && (lot3 < 101 && lot3 >= 0)) {
            validar = true;
        }
        return validar;
    }

    public boolean criarRestaurante(String nome, String morada, String cidade, String telefone, String email, String username, String password, String confirmarPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {

        boolean valido = false;
        if (telefoneUnico(telefone)) {
            if (validarTelefone(telefone)) {
                if (emailUnico(email)) {
                    if (validarEmail(email)) {
                        if (usernameUnico(username)) {
                            if (confirmarPass(password, confirmarPass)) {
                                if (validarLotacao(lotacaoEsplanada, lotacaoFum, lotacaoNFum)) {
                                    if (validarHorario(inicioAlm)) {
                                        Restaurante r = new Restaurante(nome, morada, cidade, telefone, email, username, password, confirmarPass, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
                                        listaUtilizadores.add(r);
                                        System.out.println("Restaurante criado");
                                        //JOptionPane.showMessageDialog(null, "Restaurante criado");
                                        return valido = true;
                                    } else {
                                        System.out.println("Horario invalido");
                                        JOptionPane.showMessageDialog(null, "Horario invalido");
                                    }
                                } else {
                                    System.out.println("Lotacao invalida");
                                    JOptionPane.showMessageDialog(null, "Lotacao invalida");
                                }
                            } else {
                                System.out.println("Passwords nao sao iguais");
                                JOptionPane.showMessageDialog(null, "Passwords nao sao iguais");
                            }
                        } else {
                            System.out.println("Username indisponivel");
                            JOptionPane.showMessageDialog(null, "Username indisponivel");
                        }
                    } else {
                        System.out.println("Email nao é valido");
                        JOptionPane.showMessageDialog(null, "Email nao é valido");
                    }
                } else {
                    System.out.println("Email ja esta registado");
                    JOptionPane.showMessageDialog(null, "Email ja esta registado");
                }
            } else {
                System.out.println("Telefone invalido");
                JOptionPane.showMessageDialog(null, "Telefone invalido");
            }
        } else {
            System.out.println("Telefone ja esta registado");
            JOptionPane.showMessageDialog(null, "Telefone ja esta registado");
        }
        return valido;
    }

    public boolean criarCliente(String nome, String email, String morada, String telefone, String username, String password, String confirmarPass) {

        boolean valido = false;
        if (telefoneUnico(telefone)) {
            if (validarTelefone(telefone)) {
                if (emailUnico(email)) {
                    if (validarEmail(email)) {
                        if (usernameUnico(username)) {
                            if (confirmarPass(password, confirmarPass)) {
                                Cliente c = new Cliente(nome, morada, telefone, email, username, password, confirmarPass);
                                listaUtilizadores.add(c);
                                System.out.println("Cliente criado");
                                // JOptionPane.showMessageDialog(null, "Cliente criado");
                                return valido = true;
                            } else {
                                System.out.println("Passwords não são iguais");
                                JOptionPane.showMessageDialog(null, "Passwords não são iguais");
                            }
                        } else {
                            System.out.println("Username indisponivel");
                            JOptionPane.showMessageDialog(null, "Username indisponivel");
                        }
                    } else {
                        System.out.println("Email não é valido");
                        JOptionPane.showMessageDialog(null, "Email não é valido");
                    }
                } else {
                    System.out.println("Email já esta registado");
                    JOptionPane.showMessageDialog(null, "Email já esta registado");
                }
            } else {
                System.out.println("Telemovel não é valido");
                JOptionPane.showMessageDialog(null, "Telemovel não é valido");
            }
        } else {
            System.out.println("Telemovel já registado");
            JOptionPane.showMessageDialog(null, "Telemovel já registado");
        }
        return valido;
    }

    public void atualizarDadosCliente(String nome, String morada, String telefone, String email, String password, String novaPass, String confirmarNovaPass) {

        if (nome != "") {
            getClienteAtivo().setNome(nome);
        }
        if (morada != "") {
            getClienteAtivo().setMorada(morada);
        }
        if (telefone != "") {
            if (validarTelefone(telefone)) {
                getClienteAtivo().setTelefone(telefone);
            } else {
                System.out.println("Telemovel não é valido");
                JOptionPane.showMessageDialog(null, "Telemovel não é valido");
            }
        }

        if (email != "") {
            if (emailUnico(email)) {
                if (validarEmail(email)) {
                    getClienteAtivo().setEmail(email);
                } else {
                    System.out.println("Email não é valido");
                    JOptionPane.showMessageDialog(null, "Email não é valido");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Email já esta registado");
                System.out.println("Email já esta registado");
            }
        }

        if (password != "") {
            if (novaPass != "") {
                if (confirmarNovaPass != "") {
                    if (confirmarPass(novaPass, confirmarNovaPass)) {
                        getClienteAtivo().setPassword(novaPass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords não são iguais");
                        System.out.println("Passwords não são iguais");
                    }
                }
            }
        }
    }

    public void atualizarDadosRestaurante(String nome, String morada, String telefone, String email, String password, String novaPass, String confirmarNovaPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {
//todo falta validar a lotacao, a questao de pedir variaveis int ou tudo String...

        if (nome != "") {
            getRestauranteAtivo().setNome(nome);
        }
        if (morada != "") {
            getRestauranteAtivo().setMorada(morada);
        }
        if (telefone != "") {
            if (validarTelefone(telefone)) {
                getRestauranteAtivo().setTelefone(telefone);
            } else {
                JOptionPane.showMessageDialog(null, "Telemovel não é valido");
                System.out.println("Telemovel não é valido");
            }
        }

        if (email != "") {
            if (emailUnico(email)) {
                if (validarEmail(email)) {
                    getRestauranteAtivo().setEmail(email);
                } else {
                    JOptionPane.showMessageDialog(null, "Email não é valido");
                    System.out.println("Email não é valido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email já esta registado");
                System.out.println("Email já esta registado");
            }
        }

        if (password != "") {
            if (novaPass != "") {
                if (confirmarNovaPass != "") {
                    if (confirmarPass(novaPass, confirmarNovaPass)) {
                        getRestauranteAtivo().setPassword(novaPass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords não são iguais");
                        System.out.println("Passwords não são iguais");
                    }
                }
            }
        }

        //TODO  FALTA AQUI VALIDAR LOTACAO

        if (inicioAlm != null) {
            getRestauranteAtivo().setInicioAlm(inicioAlm);
        }
        if (fimAlm != null) {
            getRestauranteAtivo().setFimAlm(fimAlm);
        }
        if (inicioJan != null) {
            getRestauranteAtivo().setInicioJan(inicioJan);
        }
        if (fimJan != null) {
            getRestauranteAtivo().setFimJan(fimJan);
        }


    }

    public void removerCliente(String username) {

        for (Utilizador u : getListaUtilizadores()) {
            if (u instanceof Cliente && u.getUsername().equalsIgnoreCase(username)) {
                u.setStatus(false);
                JOptionPane.showMessageDialog(null, "Removido com sucesso");
            }
        }
    }

    public void removerRestaurante(String username) {

        for (Utilizador u : getListaUtilizadores()) {
            if (u instanceof Restaurante && u.getUsername().equalsIgnoreCase(username)) {
                u.setStatus(false);
                JOptionPane.showMessageDialog(null, "Removido com sucesso");

            }
        }
    }

    public ArrayList<Comentario> consultarListaComentariosPorCliente(String nomeCliente) {

        ArrayList<Comentario> listaComentariosPorCliente = new ArrayList<>();
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                listaComentariosPorCliente.add(c);
            }
        }

        if (listaComentariosPorCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cliente " + nomeCliente + " não tem comentarios feitos");
            return null;
        }
        return listaComentariosPorCliente;
    }

    public ArrayList<Comentario> consultarListaComentariosPorRestaurante(String nomeRestaurante) {

        ArrayList<Comentario> listaComentariosPorRestaurante = new ArrayList<>();
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().getNome().equalsIgnoreCase(nomeRestaurante)) {
                listaComentariosPorRestaurante.add(c);
            }
        }

        if (listaComentariosPorRestaurante.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Restaurante " + nomeRestaurante + " não tem comentarios feitos");
            return null;
        }
        return listaComentariosPorRestaurante;
    }

    public ArrayList<Restaurante> consultarRestaurantePorValores(int valorMin, int valorMax) {
        ArrayList<Restaurante> restaurantesPorValores = new ArrayList<>();

        if (validarMinMenorMax(valorMin, valorMax)) {
            for (Restaurante r : getListaRestaurantes()) {
                double precoMedio =r.getPrecoMedioRestaurante();

                if (precoMedio >= valorMin && precoMedio <= valorMax) {
                    restaurantesPorValores.add(r);
                }
            }
        } else {
            //TODO atencao: acho que a interface esta de maneira diferente, nao sei se recebe dois valores...
            JOptionPane.showMessageDialog(null, "Valor minimo inserido nao é menor que o valor maximo");
            System.out.println("Valor minimo inserido nao é menor que o valor maximo");
        }

        return restaurantesPorValores;
    }

    public ArrayList<Restaurante> consultarRestaurantePorCidade(String cidade) {

        ArrayList<Restaurante> restaurantesPorCidade = new ArrayList<>();
        int count = 0;
        for (Restaurante u : getListaRestaurantes()) {
            if (u.getCidade().equalsIgnoreCase(cidade)) {
                restaurantesPorCidade.add(u);
                count++;
            }
        }
        if (count <= 0) {
            JOptionPane.showMessageDialog(null, "Não existem restaurantes!");
        }
        return restaurantesPorCidade;
    }

    public ArrayList<Restaurante> consultarRestaurantePorPontuacao(int valorMin, int valorMax) {

        ArrayList<Restaurante> restaurantesPorPontuacao = new ArrayList<>();
        int count = 0;
        if (validarMinMenorMax(valorMin, valorMax)) {
            for (Restaurante r : getListaRestaurantes()) {
                double pontuacao = getPontuacaoMediaRestaurante(r);

                if (pontuacao >= valorMin && pontuacao <= valorMax) {
                    restaurantesPorPontuacao.add(r);
                    count++;
                }
            }
            if (count <= 0) {
                JOptionPane.showMessageDialog(null, "Não existem restaurantes!");

            }
        } else {
            //TODO atencao: acho que a interface esta de maneira diferente, nao sei se recebe dois valores...
            System.out.println("Pontuacao minima nao é menor que a maxima");
            JOptionPane.showMessageDialog(null, "Pontuacao minima nao é menor que a maxima");

        }
        return restaurantesPorPontuacao;
    }

    public ArrayList<Restaurante> consultarRestaurantePorHorario(LocalTime hora) {

        ArrayList<Restaurante> restaurantesPorHorario = new ArrayList<>();
        int count = 0;

        for (Restaurante r : getListaRestaurantes()) {
            if (getClienteAtivo().restauranteAberto(r, hora) != 0) {
                restaurantesPorHorario.add(r);
                count++;
            }
        }
        if (count <= 0) {
            JOptionPane.showMessageDialog(null, "Não existem restaurantes!");

        }
        return restaurantesPorHorario;
    }

    //TODO ainda ao esta feito!
    public ArrayList<Restaurante> consultarRestaurantePorLugaresDisponiveis() {
        ArrayList<Restaurante> restaurantesPorLotacao = new ArrayList<>();
        return restaurantesPorLotacao;
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    //TODO  incompleto
//    public Comentario criarComentarioORIGINAL(String opiniao, double pontuacao, Restaurante restaurante) {
//        Calendar diaHoje = Calendar.getInstance();
//        for (Reserva r : this.getListaReservas()) {
//            if (r.getData().before(diaHoje)) {
//                restaurante = r.getRestaurante();
//                Comentario comentario = new Comentario(opiniao, pontuacao, this, restaurante);
//                getListaComentarios().add(comentario);
//                JOptionPane.showMessageDialog(null, "Obrigado pela sua opinião");
//                return comentario;
//            } else System.out.println("Nao pode comentar um restaurante que ainda nao frequentou");
//        }
//        return null;
//    }

    //TODO (prof nao) este criarComentario funciona, mas ver o de cima, é o original!//Nao esquecer como reserva nao funciona, nao da p testar 100%
    public void adicionarComentario(Cliente cliente, String opiniao, double pontuacao, Restaurante restaurante) {
        Comentario comentario = new Comentario(opiniao, pontuacao, cliente, restaurante);
        listaComentarios.add(comentario);
    }

    public void editarComentario(String opiniao, int pontuacao) {
        //TODO
        // Confirmar que tipo de campo é que recebemos da interface, se é int ou string ou outra coisa qualquer...
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().equals(this)) {
                if (opiniao != null) {
                    c.setOpiniao(opiniao);
                }
                if (pontuacao <= 0) {
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

    public boolean validarMinMenorMax(int valorMin, int valorMax) {
        boolean menor = false;
        if (valorMin < valorMax) {
            menor = true;
        }
        return menor;
    }

    public double getPontuacaoMediaRestaurante(Restaurante restaurante) {
        double count = 0;
        double totalPontuacao = 0;
        double media = 0;
        for (Comentario u : getListaComentarios()) {
            if (u.getRestaurante().getNome().equals(restaurante.nome)) {
                count++;
                totalPontuacao += u.getPontuacao();
            }
        }
        if (count > 0) {
            media = totalPontuacao / count;
        }
        if (media <= 0.0001) {
            return 0;
        }
        return media;
    }

    //TODO - tem de ter como parametro o dia! Incompleto
    public double lotacaoTotalDisponivel() {
        return (getRestauranteAtivo().getLotacaoEsplanada() + getRestauranteAtivo().getLotacaoFum() + getRestauranteAtivo().getLotacaoNFum());
    }

}

