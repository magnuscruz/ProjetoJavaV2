package com.company;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Sistema implements Serializable {
    public ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    public ArrayList<Comentario> listaComentarios = new ArrayList<>();
    protected Utilizador utilizarAtivo;

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
            Utilizador u = listaUtilizadores.get(3);
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
                    Utilizador u = listaUtilizadores.get(i);
                    this.utilizarAtivo = u;
                    valido = true;
                } else {
                    Utilizador u = listaUtilizadores.get(i);
                    this.utilizarAtivo = u;
                    valido = true;
                }
            } else {
                System.out.println("Utilizador nao existe ou pass incorrecta");
            }
        }
        if (valido) {
            return "";//Para na consola da interface, saber que tudo correu bem
        } else return "Login invalido";
    }

    public void criarRestaurante(String nome, String morada, String telefone, String email, String username, String password, String confirmarPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {
        Boolean mailValido = validarEmail(email);
        Boolean userUnico = usernameUnico(username);
        Boolean passIgual = confirmarPass(password, confirmarPass);
//Se der para mostrar as mensagens atraves do interface, é mellhor assim do que como esta em baixo.
//        if (userUnico && passIgual && mailValido) {
//            r = new Restaurante(nome, morada, telefone, email, username, password, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
//            listaUtilizadores.add(r);
//        }
        if (mailValido) {
            if (userUnico) {
                if (passIgual) {
                   Restaurante r = new Restaurante(nome, morada, telefone, email, username, password, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
                    listaUtilizadores.add(r);
                    System.out.println("Restaurante criado");
                } else System.out.println("Passwords nao sao iguais");
            } else System.out.println("Username indisponivel");
        } else System.out.println("Email nao é valido");

    }

    public void criarCliente(String nome, String morada, String telefone, String email, String username, String password, String confirmarPass) {
        Boolean mailValido = validarEmail(email);
        Boolean userUnico = usernameUnico(username);
        Boolean passIgual = confirmarPass(password, confirmarPass);

        if (mailValido) {
            if (userUnico) {
                if (passIgual) {
                    Cliente c = new Cliente(nome, morada, telefone, email,username,password);
                    listaUtilizadores.add(c);
                    System.out.println("Cliente criado");
                } else System.out.println("Passwords nao sao iguais");
            } else System.out.println("Username indisponivel");
        } else System.out.println("Email nao é valido");
    }

    public boolean validarEmail(String email) {
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

    public boolean usernameUnico(String username) {
        boolean unico = false;

        for (int i = 0; i < listaUtilizadores.size(); i++) {
            if (username.equalsIgnoreCase(listaUtilizadores.get(i).getUsername())) {
                unico = true;
            }
        }
        return unico;
    }

    public boolean confirmarPass(String pass1, String pass2) {
        boolean correta = false;
        if (pass1.equals(pass2)) {
            correta = true;
        } else {
            System.out.println("Passwords nao sao iguais");
        }
        return correta;
    }

    public ArrayList<Restaurante> getListaRestaurantes() {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        for (Utilizador u : listaUtilizadores) {
            if (u instanceof Restaurante) {
                restaurantes.add((Restaurante) u);
            }
        }
        return restaurantes;
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
}
