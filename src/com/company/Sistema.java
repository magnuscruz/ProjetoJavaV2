package com.company;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Sistema implements Serializable {
    private ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    private ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private static HashMap<Class, Integer> mapaDeSequenciasID = new HashMap<>();
    private Utilizador utilizarAtivo;

    public Sistema() {
        try {
            FicheiroDeObjectos ficheiroOb = new FicheiroDeObjectos();
            ficheiroOb.abreLeitura("FicheiroProjeto.dat");
            try {
                Object obj = ficheiroOb.leObjecto();
                if (obj instanceof Sistema) {
                    Sistema sistema = (Sistema) obj;
                    listaComentarios = sistema.listaComentarios;
                    listaUtilizadores = sistema.listaUtilizadores;
                    listaReservas = sistema.listaReservas;
                }
                ficheiroOb.fechaLeitura();
                //Se a lista for vazia, inicia com o ID = 1
                if (listaComentarios == null || listaComentarios.isEmpty()) {
                    listaComentarios = new ArrayList<>();
                    mapaDeSequenciasID.put(Comentario.class, 1);
                } else {
                    listaComentarios.sort((c1,c2)->c1.getIdComentario().compareTo(c2.getIdComentario()));
                    mapaDeSequenciasID.put(Comentario.class, listaComentarios.get(listaComentarios.size()-1).getIdComentario());
                }
                //Se a lista for vazia, inicia com o ID = 1
                if (listaUtilizadores == null || listaUtilizadores.isEmpty()) {
                    listaUtilizadores = new ArrayList<>();
                    mapaDeSequenciasID.put(Utilizador.class, 1);
                } else {
                    listaUtilizadores.sort((c1,c2)->c1.getId().compareTo(c2.getId()));
                    mapaDeSequenciasID.put(Utilizador.class, listaUtilizadores.get(listaUtilizadores.size()-1).getId());
                }
                //Se a lista for vazia, inicia com o ID = 1
                if (listaReservas == null || listaReservas.isEmpty()) {
                    listaReservas = new ArrayList<>();
                    mapaDeSequenciasID.put(Reserva.class, 1);
                } else {
                    listaReservas.sort((c1,c2)->c1.getIdReserva().compareTo(c2.getIdReserva()));
                    mapaDeSequenciasID.put(Reserva.class, listaReservas.get(listaReservas.size()-1).getIdReserva());
                }
            } catch (Exception e) {
                e.printStackTrace();
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

    //TODO - TESTAR - ver no debug se faz logout
    public void logout() {
        this.utilizarAtivo = null;
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

    //TODO inserido por Adriano 09/01
//    public boolean validarNome(String nome) {
//        char[] c;
//        boolean a = false;
//        c = nome.toCharArray();
//
//        for (int i = 0; i < c.length; i++) {
//            if (Character.isAlphabetic(c[0])) {
//                if (Character.isAlphabetic(c[i]) || Character.isSpaceChar(c[i])) {
//                    a = true;
//                }else
//                    return false;
//            } else {
//                return false;
//            }
//        }
//        if (!a) {
//            return false;
//        }
//        return true;
//    }

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
                                        gravarRestaurante(nome, morada, cidade, telefone, email, username, password, confirmarPass, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
                                        return true;
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

    private void gravarRestaurante(String nome, String morada, String cidade, String telefone, String email, String username, String password, String confirmarPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {
        Restaurante r = new Restaurante(nome, morada, cidade, telefone, email, username, password, confirmarPass, lotacaoEsplanada, lotacaoFum, lotacaoNFum, inicioAlm, fimAlm, inicioJan, fimJan);
        r.setId(getNovoId(Utilizador.class));
        listaUtilizadores.add(r);
        gravarSistema();
    }

    private Integer getNovoId(Class  tipo) {
        Integer id = mapaDeSequenciasID.get(tipo)+1;
        mapaDeSequenciasID.put(tipo, id);
        return id;
    }

//    public void sequenciaClienteId (){
//        int num = clienteId;
//        int tamanho = getListaClientes().size();
//        for (int i = 0; i < getListaClientes().size(); i++) {
//            if (getListaClientes().get(i).getId()==num){
//                num = getListaClientes().get(i).getId()+1;
//            }
//        }
//        clienteId=num+1;
//    }

    public boolean criarCliente(String nome, String email, String morada, String telefone, String username, String password, String confirmarPass) {
        boolean valido = false;
        //if(validarNome (nome)) { // inserido a pedido do Adriano
        if (emailUnico(email)) { //(emailUnico(email) || email=="")
            if (validarEmail(email)) {
                // if (morada == "") { //
                if (telefoneUnico(telefone)) {//(telefoneUnico(telefone) || telefone=="")
                    if (validarTelefone(telefone)) {
                        if (usernameUnico(username)) { // (usernameUnico(username) || username=="")
                            if (confirmarPass(password, confirmarPass)) { //(confirmarPass(password, confirmarPass)
                                gravarCliente(nome, email, morada, telefone, username, password, confirmarPass);
                                return true;
                            } else {
                                System.out.println("Passwords não são iguais");
                                JOptionPane.showMessageDialog(null, "Passwords não são iguais");
                            }
                        } else {
                            System.out.println("Username indisponivel");
                            JOptionPane.showMessageDialog(null, "Username indisponivel");
                        }
                    } else {
                        System.out.println("Telemovel não é valido");
                        JOptionPane.showMessageDialog(null, "Telemovel não é valido");

                    }
                } else {
                    System.out.println("Telemovel já registado");
                    JOptionPane.showMessageDialog(null, "Telemovel já registado");
                }
//
//                } else {
//                    System.out.println("Tem de inserir morada");
//                    JOptionPane.showMessageDialog(null, "Tem de inserir morada");
//                }
            } else {
                System.out.println("Email não é valido");
                JOptionPane.showMessageDialog(null, "Email não é valido");

            }
        } else {
            System.out.println("Email já esta registado");
            JOptionPane.showMessageDialog(null, "Email já esta registado");
        }
//        } else {
//            System.out.println("O nome não é válido");
//        }
        return valido;
    }

    private void gravarCliente(String nome, String email, String morada, String telefone, String username, String password, String confirmarPass) {
        Cliente c = new Cliente(nome, morada, telefone, email, username, password, confirmarPass);
        c.setId(getNovoId(Utilizador.class));
        listaUtilizadores.add(c);
        gravarSistema();
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
        gravarSistema();
    }

    public void atualizarDadosRestaurante(String nome, String morada, String telefone, String email, String password, String novaPass, String confirmarNovaPass, int lotacaoEsplanada, int lotacaoFum, int lotacaoNFum, LocalTime inicioAlm, LocalTime fimAlm, LocalTime inicioJan, LocalTime fimJan) {


//TODO falta validar a lotacao, a questao de pedir variaveis int ou tudo String...

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
        gravarSistema();

    }


    public boolean verificarValidadeDatas(GregorianCalendar dataAnterior, GregorianCalendar dataPosterior) {

        if (dataAnterior.before(dataPosterior)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Datas não são validas, insira novamente");
        }
        return false;
    }

    public ArrayList<Comentario> consultarListaComentariosProprios(Cliente cliente) {

        ArrayList<Comentario> listaComentariosProprios = new ArrayList<>();
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().getNome().equals(cliente.getNome()) && c.getStatus()) {
                listaComentariosProprios.add(c);
            }
        }

        if (listaComentariosProprios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cliente não tem comentários feitos");
            return null;
        }
        return listaComentariosProprios;
    }

    public ArrayList<Comentario> consultarListaComentariosPorCliente(String nomeCliente) {

        ArrayList<Comentario> listaComentariosPorCliente = new ArrayList<>();
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().getNome().equalsIgnoreCase(nomeCliente) && c.getStatus()) {
                listaComentariosPorCliente.add(c);
            }
        }
        if (listaComentariosPorCliente.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Cliente " + nomeCliente + " não tem comentarios feitos");
            return null;
        }
        return listaComentariosPorCliente;
    }

    public ArrayList<Comentario> consultarListaComentariosPorRestaurante(String nomeRestaurante) {

        ArrayList<Comentario> listaComentariosPorRestaurante = new ArrayList<>();
        for (Comentario c : getListaComentarios()) {
            if (c.getRestaurante().getNome().equalsIgnoreCase(nomeRestaurante) && c.getStatus()) {
                listaComentariosPorRestaurante.add(c);
            }
        }

        if (listaComentariosPorRestaurante.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Restaurante " + nomeRestaurante + " não tem comentarios feitos");
            return null;
        }
        return listaComentariosPorRestaurante;
    }

    public ArrayList<Comentario> consultarListaComentariosPorIntervaloDatas(GregorianCalendar dataAnterior, GregorianCalendar dataPosterior) {
        boolean valido = verificarValidadeDatas(dataAnterior, dataPosterior);
        int count = 0;
        ArrayList<Comentario> listaComentariosPorData = new ArrayList<>();

        if (valido) {
            for (Comentario c : getListaComentarios()) {
                if (c.getDataComentario().after(dataAnterior) && c.getDataComentario().before(dataPosterior) && c.getStatus()) {
                    listaComentariosPorData.add(c);
                    count++;
                }
            }
            if (listaComentariosPorData.isEmpty()) {
                //JOptionPane.showMessageDialog(null, "Não existem comentarios dentro dessas datas");
                return null;
            }
        }
        return listaComentariosPorData;
    }

    public void responderComentario(Restaurante restaurante, Cliente cliente, String resposta) {

        for (Comentario c : getListaComentarios()) {
            if (c.getRestaurante().equals(restaurante) && c.getCliente().equals(cliente)) {
                Comentario comentario = new Comentario(cliente, restaurante);
                comentario.setOpiniao(resposta);
                listaComentarios.add(comentario);
            }
        }
    }
    /**
     * Consultar Restaurantes ordenados pela pontuação média.
     *
     * @return
     */
    public ArrayList<Restaurante> consultarRestaurantesPorOrdemPontuacao() {
        ArrayList<Restaurante> listaOrdenada = new ArrayList<>();
        listaOrdenada.addAll(getListaRestaurantes());
        listaOrdenada.sort((r1, r2) -> Double.valueOf(getPontuacaoMediaRestaurante(r1)).compareTo(Double.valueOf(getPontuacaoMediaRestaurante(r2))));
        return listaOrdenada;
    }

    public ArrayList<Restaurante> consultarRestaurantePorValores(String valorMin2, String valorMax2) {
        int valorMin = Integer.parseInt(valorMin2);
        int valorMax = Integer.parseInt(valorMax2);

        ArrayList<Restaurante> restaurantesPorValores = new ArrayList<>();

        if (validarMinMenorQueMax(valorMin, valorMax)) {
            for (Restaurante r : getListaRestaurantes()) {
                double precoMedio = r.getPrecoMedioRestaurante();

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

    public ArrayList<Restaurante> consultarRestaurantePorPontuacao(String valorMin2, String valorMax2) {
        int valorMin = Integer.parseInt(valorMin2);
        int valorMax = Integer.parseInt(valorMax2);

        ArrayList<Restaurante> restaurantesPorPontuacao = new ArrayList<>();
        int count = 0;
        if (validarMinMenorQueMax(valorMin, valorMax)) {
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

    public int consultarRestaurantesComDisponibilidade (Restaurante restaurante, GregorianCalendar dia){

        int disponibilidade = restaurante.getLotacaoEsplanadaAlmoco()+restaurante.getLotacaoEsplanadaJantar()
                +restaurante.getLotacaoFumAlmoco()+restaurante.getLotacaoFumJantar()+restaurante.getLotacaoNFumAlmoco()+
                restaurante.getLotacaoFumJantar();
        if (disponibilidade<=0){
            return 0;
        }
        return disponibilidade;
    }

    public ArrayList<Restaurante> consultarRestaurantePorLotacao (GregorianCalendar dia, int numLugares){

        ArrayList<Restaurante> restaurantesPorLotacao = new ArrayList<>();

        for (Restaurante r : getListaRestaurantes()) {
            if (consultarRestaurantesComDisponibilidade(r,dia)>=numLugares) {
                restaurantesPorLotacao.add(r);
            }
        }
        if (restaurantesPorLotacao.isEmpty()) {
            //    JOptionPane.showMessageDialog(null, "Não existem restaurantes!");

        }
        return restaurantesPorLotacao;
    }

    public ArrayList<Reserva> consultarReservasPorCliente(String nomeCliente) {
        ArrayList<Reserva> listaReservasCliente = new ArrayList<>();

        for (Reserva r : getListaReservas()) {
            if (r.getCliente().getNome().equals(nomeCliente) && getRestauranteAtivo().getNome().equals(r.restaurante.getNome()) && r.getStatus()) {
                listaReservasCliente.add(r);
            }
        }
        return listaReservasCliente;
    }

    /**
     * Consultar reservas do cliente ativo.
     * @return
     */
    public List<Reserva> consultarHistoricoReservas() {
        GregorianCalendar diaHoje = new GregorianCalendar();
        diaHoje.toInstant();
        return getListaReservas().stream().filter(r -> diaHoje.after(r.getData()) && getClienteAtivo().getNome().equals(r.getCliente().getNome())).collect(Collectors.toList());
    }

    public ArrayList<Reserva> consultarReservasTakeAwayPorValoresMedios(String valor1, String valor2) {
        int valorMin = Integer.parseInt(valor1);
        int valorMax = Integer.parseInt(valor2);

        ArrayList<Reserva> listaReservasTakeAwayValoresMedios = new ArrayList<>();

        if (validarMinMenorQueMax(valorMin, valorMax)) {
            for (Reserva r : getListaReservas()) {
                if (getRestauranteAtivo().getNome().equals(r.getRestaurante().getNome()) && r instanceof TakeAway
                        && ((TakeAway) r).getValorTotal() >= valorMin && ((TakeAway) r).getValorTotal() <= valorMax && r.getStatus()) {
                    listaReservasTakeAwayValoresMedios.add(r);
                }
            }
        }
        return listaReservasTakeAwayValoresMedios;
    }

    public ArrayList<Reserva> consultarReservasPorData(GregorianCalendar data1, GregorianCalendar data2) {
        ArrayList<Reserva> listaReservasPorData = new ArrayList<>();
        boolean datasValidas = verificarValidadeDatas(data1, data2);
        if (datasValidas) {
            for (Reserva r : getListaReservas()) {
                if (getRestauranteAtivo().getNome().equals(r.getRestaurante().getNome()) && r.getData().after(data1)
                        && r.getData().before(data2) && r.getStatus()) {
                    listaReservasPorData.add(r);
                }
            }
            if (listaReservasPorData.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem reservas dentro desse intervalo datas");
                return null;
            }
        }
        return listaReservasPorData;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public double getPrecoMedioReservaTakeAway() {
        double media = 0;
        double precoTotal = 0;
        int count =0;
        for (Reserva r : getListaReservas()) {
            if (r instanceof TakeAway) {
                precoTotal += ((TakeAway) r).getValorTotal();
            }
        }
        if (count > 0){
            return media = precoTotal/count;
        }
        JOptionPane.showMessageDialog(null, "Sem reservas TakeAway!");
        return 0;
    }

    public ArrayList<Reserva> getReservasTakeAwayTodas() {

        ArrayList<Reserva> listaReservasTakeAway = new ArrayList<>();

        for (Reserva r : getListaReservas()) {
            if (getRestauranteAtivo().getNome().equals(r.getRestaurante().getNome()) && r instanceof TakeAway && r.getStatus()) {
                listaReservasTakeAway.add(r);
            }
        }
        return listaReservasTakeAway;
    }

    public ArrayList<Reserva> getReservasPresencialTodas() {

        ArrayList<Reserva> listaReservasPresencial = new ArrayList<>();

        for (Reserva r : getListaReservas()) {
            if (getRestauranteAtivo().getNome().equals(r.getRestaurante().getNome()) && r instanceof Presencial && r.getStatus()) {
                listaReservasPresencial.add(r);
            }
        }
        return listaReservasPresencial;
    }

    public ArrayList<Reserva> consultarReservasAtivas(Cliente cliente, GregorianCalendar data) {
        GregorianCalendar dataHoje = new GregorianCalendar();
        dataHoje.toInstant();

        ArrayList<Reserva> listaReservasAtivas = new ArrayList<>();
        for (Reserva r : getListaReservas()) {
            if (cliente.getNome().equals(r.getCliente().getNome()) && r.getData().after(dataHoje) && r.getStatus()) {
                listaReservasAtivas.add(r);
            }
        }
        return listaReservasAtivas;
    }

    //    //TODO acho que so preciso disto para restaurante, mas vou deixar ficar aqui para ja
//    public double lotacaoTotalRestaurante(Restaurante restaurante) {
//        double lotacaoTotalRest = 0;
//
//        for (Restaurante r : getListaRestaurantes()) {
//            if (r.getId() == restaurante.getId()) {
//                lotacaoTotalRest = r.getLotacaoFum() + r.getLotacaoNFum() + r.getLotacaoEsplanada();
//            }
//        }
//        return lotacaoTotalRest;
//    }
    //TODO Testar - quando reserva presencial estiver a funcionar!
//    public ArrayList<Restaurante> consultarRestaurantePorLugaresDisponiveis() {
//        ArrayList<Restaurante> restaurantesPorLotacao = new ArrayList<>();
//
//        for (Restaurante r : getListaRestaurantes()) {
//            if (r.getRestaurante().disponibilidadeRestaurante(r.getRestaurante(), dia) >= numeroLugares) {
//                restaurantesPorLotacao.add(r);
//            }
//        }
//        if (restaurantesPorLotacao.isEmpty()) {
//            return null;
//        }
//
//        return restaurantesPorLotacao;
//    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    //TODO  testar quando criarReserva estiver operacional
    public void adicionarComentario2(Cliente cliente, String opiniao, double pontuacao, Restaurante restaurante) {

        for (Reserva r : getListaReservas()) {
            if (r.getCliente().getNome().equals(cliente.getNome()) && r.getRestaurante().getNome().equals(restaurante.getNome())
                    && r.getStatus()) {
                adicionarComentario(opiniao, pontuacao, cliente, restaurante);
                break;
            }
        }
    }

    public void adicionarReserva(Cliente cliente, Restaurante restaurante, GregorianCalendar data, LocalTime hora, Class tipo, Integer zona, int quantidade) {
        Reserva reserva = null;
        if (tipo.equals(TakeAway.class)) {
            reserva = new TakeAway(cliente, restaurante, data, hora, quantidade);
        } else {
            reserva = new Presencial(cliente, restaurante, data, hora, zona, quantidade);
        }
        gravarReserva(reserva);
    }

    private void gravarReserva(Reserva reserva) {
        reserva.setIdReserva(getNovoId(Reserva.class));
        listaReservas.add(reserva);
        gravarSistema();
    }


    //TODO (prof nao) este criarComentario funciona, mas ver o de cima, é o original!//Nao esquecer como reserva nao funciona, nao da p testar 100%
    public void adicionarComentario(String opiniao, double pontuacao, Cliente cliente, Restaurante restaurante) {
        Comentario comentario = new Comentario(cliente, restaurante);
        comentario.setOpiniao(opiniao);
        comentario.setPontuacao(pontuacao);
        gravarComentario(comentario);

    }

    private void gravarComentario(Comentario comentario) {
        comentario.setIdComentario(getNovoId(Comentario.class));
        listaComentarios.add(comentario);
        gravarSistema();
    }

    public void editarComentario(String opiniao, int pontuacao) {
        //TODO
        // Confirmar que tipo de campo é que recebemos da interface, se é int ou string ou outra coisa qualquer...
        for (Comentario c : getListaComentarios()) {
            if (c.getCliente().equals(this) && c.getStatus()) {
                if (opiniao != null) {
                    c.setOpiniao(opiniao);
                }
                if (pontuacao <= 0) {
                    c.setPontuacao(pontuacao);
                }
            }
            gravarSistema();
        }
    }

    //TODO falta - caso tenho mais de um comentario no mesmo restaurante vai eliminar todos...
    public void apagarComentario(Restaurante restaurante) {
        for (Comentario c : getListaComentarios()) {
            if (c.equals(this) && c.getRestaurante().equals(restaurante)) {
                c.setStatus(false);
            }
            gravarSistema();
        }
    }

    public boolean validarMinMenorQueMax(int valorMin, int valorMax) {
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
            if (u.getRestaurante().getNome().equals(restaurante.nome) && u.getStatus()) {
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

    public LocalTime stringParaLocalTime(String hora) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            // String hora = "13:30";
            Date d = sdf.parse(hora);
            int hora1 = d.getHours();
            int minuto = d.getMinutes();
            LocalTime horaReserva = LocalTime.of(hora1, minuto);

            return horaReserva;

        } catch (ParseException e) {
            e.getMessage();
        }
        JOptionPane.showMessageDialog(null, "Insira data neste formato: hh:mm");
        return null;
    }
}