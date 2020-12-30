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

    public void adicionarComentarioCliente(Cliente cliente, String opiniao, double pontuacao, Restaurante restaurante) {
        Comentario comentario = cliente.criarComentario(opiniao, pontuacao, restaurante);
        // Comentario comentario = new Comentario(opiniao, pontuacao,getClienteAtivo(), restaurante);
        if (comentario != null) {
            listaComentarios.add(comentario);
        }
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

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void utilizadorExiste(String username) {
        boolean existe = false;
        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (username.equalsIgnoreCase(listaUtilizadores.get(i).getUsername())) {
                String nomeClasse = listaUtilizadores.get(i).getClass().getSimpleName();//// Imprime o nome da Classe. Tem é de se associar a uma variavel
                System.out.println("Utilizador com o username: " + listaUtilizadores.get(i).getUsername() + " é do tipo: " + nomeClasse);
                existe = true;
            }
        }
        if (!existe) {
            System.out.println("Nao existe");
        }
    }

    public String loginTeste(String username, String pass) {
        /// percorrer lista de utilizadores ate encontrar cliente
        // verificar password
        if (username.equals("restaurante")) {
            Utilizador u = listaUtilizadores.get(1);

        } else {
            Utilizador u = listaUtilizadores.get(2);
        }
        // se login for valido
        // this.utilizarAtivo = u;
        return "";
        // Se login invalido
//        this.utilizarAtivo = null;
//        return "Utilizador inválido";
    }

    public String login2(String username, String pass) {
        boolean valido = false;
        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (username.equals(listaUtilizadores.get(i).getUsername()) && pass.equals(listaUtilizadores.get(i).getPassword())) {
                if (listaUtilizadores.get(i) instanceof Restaurante) {
                    //  Utilizador u = listaUtilizadores.get(i);
                    this.utilizarAtivo = listaUtilizadores.get(i);
                    // this.utilizarAtivo = u;
                    valido = true;
                } else {
                    Utilizador u = listaUtilizadores.get(i);
                    this.utilizarAtivo = u;
                    valido = true;
                }
            }
        }
        if (valido) {
            return "Login efetuado com sucesso";//Para na consola da interface, saber que tudo correu bem
        } else return "Login invalido";
    }

    private boolean emailUnico(String email) {
        Boolean unico = true;
        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (email.equalsIgnoreCase(listaUtilizadores.get(i).getEmail())) {
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
//Se der para mostrar as mensagens atraves do interface, é mellhor assim do que como esta em baixo.
//        if (mailUnico && userUnico && passIgual && mailValido) {
//            r = new Restaurante(nome, morada, telefone, email, username, password, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
//            listaUtilizadores.add(r);
//        }

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
                    for (int i = 0; i < listaUtilizadores.size(); i++) {
                        if (listaUtilizadores.get(i) instanceof Cliente && listaUtilizadores.get(i).equals(this)) {//Funcionara???
                            listaUtilizadores.get(i).setNome(nome);
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

    public void consultarRestaurantePorValores(int valorMin, int valorMax) {
        if (validarMinMenorMax(valorMin, valorMax)) {

        } else System.out.println("Valor minimo inserido nao é menor que o valor maximo");
    }

    public void consultarRestaurantePorHorario() {

    }

    public void consultarRestaurantePorLotacao() {
    }

    public void consultarRestaurantePorCidade(String cidade) {

        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (listaUtilizadores.get(i) instanceof Restaurante && listaUtilizadores.get(i).getMorada().equalsIgnoreCase(cidade)) {
                listaUtilizadores.get(i);
            }
        }
    }

    public void consultarRestaurantePorPontuacao(int valorMin, int valorMax) {
        if (validarMinMenorMax(valorMin, valorMax)) {
            for (int i = 0; i < listaUtilizadores.size(); i++) {
                if (listaUtilizadores.get(i) instanceof Restaurante) {
                    if (((Restaurante) listaUtilizadores.get(i)).getPontuacaoMedia() >= valorMin && ((Restaurante) listaUtilizadores.get(i)).getPontuacaoMedia() <= valorMax) {
                        listaUtilizadores.get(i);
                    }
                }
            }
        } else System.out.println("Pontuacao minima nao é menor que a maxima");
    }

    public double getPontuacaoMediaProprioRestaurante(Restaurante restaurante) {
        return restaurante.getPontuacaoMedia();
    }

}

