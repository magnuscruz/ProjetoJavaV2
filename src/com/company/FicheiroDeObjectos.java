package com.company;

import java.io.*;

public class FicheiroDeObjectos {

    // Atributos

    private ObjectInputStream iS;
    private ObjectOutputStream oS;

//M�todo para abrir um ficheiro para leitura
//Recebe:
//  nomeDoFicheiro - nome do ficheiro
//Devolve:
//  true se o ficheiro j� existir, false no caso contr�rio

    public boolean abreLeitura (String nomeDoFicheiro) {

        try {

            iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            return true;
        }

        catch (IOException e) {

            return false;
        }

    }

//M�todo para abrir um ficheiro para escrita
//Recebe:
//  nomeDoFicheiro - nome do ficheiro

    public void abreEscrita (String nomeDoFicheiro) throws IOException {

        oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));

    }

//M�todo para ler um objecto de um ficheiro
//Devolve:
//  objecto lido

    public Object leObjecto () throws IOException, ClassNotFoundException {

        return iS.readObject();

    }

//M�todo para escrever um objecto num ficheiro
//Recebe:
//  o - objecto a escrever

    public void escreveObjecto (Object o) throws IOException {

        oS.writeObject(o);

    }

//M�todo para fechar um ficheiro aberto em modo leitura

    public void fechaLeitura () throws IOException {

        iS.close();

    }

//M�todo para fechar um ficheiro aberto em modo escrita

    public void fechaEscrita () throws IOException {

        oS.close();

    }

}
