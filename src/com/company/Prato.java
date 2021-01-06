package com.company;

public class Prato {
    private static int idd=1;
    private int idPrato;
    private String nome;
    private String descricao;
    private double preco;
    private boolean status;

    public Prato(String nome, String descricao, double preco) {
        this.idPrato = idd++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = true;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                        ", descricao='" + descricao + '\'' +
                        ", preco=" + preco +
                        '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(int idPrato) {
        this.idPrato = idPrato;
    }
}