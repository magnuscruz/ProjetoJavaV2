package com.company;

import java.io.Serializable;
import java.util.ArrayList;


public class Sistema implements Serializable {
    public ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    public ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private Utilizador utilizarAtivo;



}
