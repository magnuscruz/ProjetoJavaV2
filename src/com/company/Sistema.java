package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sistema implements Serializable {
    private ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    private ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private Utilizador utilizarAtivo;

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

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void adicionarComentarioCliente(Cliente cliente, String opiniao, double pontuacao, Restaurante restaurante) {
        Comentario comentario = cliente.criarComentario(opiniao, pontuacao, restaurante);
        // Comentario comentario = new Comentario(opiniao, pontuacao,getClienteAtivo(), restaurante);
        if (comentario != null) {
            listaComentarios.add(comentario);
        }
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

    public String login(String username, String pass) {
        boolean valido = false;
        //NAO Percebi o porque do instanceof, creio que isso é feito quando faco o getutilizadorativo

//        for (int i = 0; i < listaUtilizadores.size(); i++) {
//            if (username.equals(listaUtilizadores.get(i).getUsername()) && pass.equals(listaUtilizadores.get(i).getPassword())) {
//                if (listaUtilizadores.get(i) instanceof Restaurante) {
//                    //  Utilizador u = listaUtilizadores.get(i);
//                    this.utilizarAtivo = listaUtilizadores.get(i);
//                    // this.utilizarAtivo = u;
//                    valido = true;
//                } else {
//                    Utilizador u = listaUtilizadores.get(i);
//                    this.utilizarAtivo = u;
//                    valido = true;
//                }
//            }
//        }

        for (Utilizador u : listaUtilizadores) {
            if (username.equals(u.getUsername()) && pass.equals(u.getPassword())) {
                this.utilizarAtivo = u;
                valido = true;
            }
        }
        if (valido) {
            return "Login efetuado com sucesso";//Para na consola da interface, saber que tudo correu bem
        } else return "Login invalido";
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

    public void criarRestaurante(String nome, String morada, String cidade, String telefone, String email, String username, String password, String confirmarPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {

        if (emailUnico(email)) {
            if (validarEmail(email)) {
                if (usernameUnico(username)) {
                    if (confirmarPass(password, confirmarPass)) {
                        Restaurante r = new Restaurante(nome, morada, cidade, telefone, email, username, password, confirmarPass, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
                        listaUtilizadores.add(r);
                        System.out.println("Restaurante criado");
                    } else System.out.println("Passwords nao sao iguais");
                } else System.out.println("Username indisponivel");
            } else System.out.println("Email nao é valido");
        } else System.out.println("Email ja esta registado");
    }

    public void criarCliente(String nome, String morada, String telefone, String email, String username, String password, String confirmarPass) {

        if (emailUnico(email)) {
            if (validarEmail(email)) {
                if (usernameUnico(username)) {
                    if (confirmarPass(password, confirmarPass)) {
                        Cliente c = new Cliente(nome, morada, telefone, email, username, password, confirmarPass);
                        listaUtilizadores.add(c);
                        System.out.println("Cliente criado");
                    } else System.out.println("Passwords nao sao iguais");
                } else System.out.println("Username indisponivel");
            } else System.out.println("Email nao é valido");
        } else System.out.println("Email ja esta registado");
    }

    public void atualizarDadosCliente(String nome, String morada, String telefone, String email, String password, String novaPass, String confirmarNovaPass) {

        if (emailUnico(email)) {
            if (validarEmail(email)) {
                if (confirmarPass(novaPass, confirmarNovaPass)) {
                    for (Utilizador u : listaUtilizadores) {
                        if (u instanceof Cliente && u.equals(this)) {//Funcionara??
                            u.setNome(nome);
                        }
                    }
                    //Cliente c = new Cliente(nome, morada, telefone, email, username, password);
                    // NAO PODE ser new, tenho de atualizar o anterior!
                    System.out.println("Dados atualizados");
                } else System.out.println("Passwords nao sao iguais");
            } else System.out.println("Email nao é valido");
        } else System.out.println("Email ja esta registado");
    }

    public void atualizarDadosRestaurante(String nome, String morada, String telefone, String email, String password, String novaPass, String confirmarNovaPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {

        if (emailUnico(email)) {
            if (validarEmail(email)) {
                if (confirmarPass(novaPass, confirmarNovaPass)) {
                    //  Restaurante r = new Restaurante(nome, morada, telefone, email, username, password, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
                    //listaUtilizadores.add(r);
                    //Nao pode ser new Restaurante, porque nesse caso o ID ia ser alterado! Tenho de alterar o existente!!
                    System.out.println("Restaurante criado");
                } else System.out.println("Passwords nao sao iguais");
            } else System.out.println("Email nao é valido");
        } else System.out.println("Email ja esta registado");
    }

    public void removerCliente(String username) {

    }

    public boolean validarMinMenorMax(int valorMin, int valorMax) {
        boolean menor = false;
        if (valorMin < valorMax) {
            menor = true;
        }
        return menor;
    }

    public double getPontuacaoMediaProprioRestaurante(Restaurante restaurante) {
        return restaurante.getPontuacaoMedia();
    }

    public ArrayList<Restaurante> consultarRestaurantePorValores(int valorMin, int valorMax) {
        ArrayList<Restaurante> restaurantesPorValores = new ArrayList<>();

        if (validarMinMenorMax(valorMin, valorMax)) {

        } else System.out.println("Valor minimo inserido nao é menor que o valor maximo");

        return restaurantesPorValores;
    }

    public ArrayList<Restaurante> consultarRestaurantePorHorario() {
        ArrayList<Restaurante> restaurantesPorHorario = new ArrayList<>();
return  restaurantesPorHorario;
    }

    public ArrayList<Restaurante> consultarRestaurantePorLotacao() {
        ArrayList<Restaurante> restaurantesPorLotacao = new ArrayList<>();
return restaurantesPorLotacao;
    }

    public ArrayList<Restaurante> consultarRestaurantePorCidade(String cidade) {
        ArrayList<Restaurante> restaurantesPorCidade = new ArrayList<>();
        for (Restaurante u : getListaRestaurantes()) {
            if (u.getCidade().equalsIgnoreCase(cidade)) {
                restaurantesPorCidade.add(u);
            }
        }
        return restaurantesPorCidade;
    }

    public ArrayList<Restaurante> consultarRestaurantePorPontuacao(int valorMin, int valorMax) {
        ArrayList<Restaurante> restaurantesPorPontuacao = new ArrayList<>();
        if (validarMinMenorMax(valorMin, valorMax)) {
            for (Restaurante r : getListaRestaurantes()){
                if (r.getPontuacaoMedia() >= valorMin && r.getPontuacaoMedia() <= valorMax){
                    restaurantesPorPontuacao.add(r);
                }
            }
        } else System.out.println("Pontuacao minima nao é menor que a maxima");
        return restaurantesPorPontuacao;
    }



}

