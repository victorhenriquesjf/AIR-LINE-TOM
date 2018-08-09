package com.example.adilson.airlinetom.Model;

public class CartaoCredito {

    private int id;
    private String cartao;
    private int mes;
    private int ano;
    private String tarja;
    private double valor;
    private String status;

    public CartaoCredito() {
    }

    public CartaoCredito(int id, String cartao, int mes, int ano, String tarja, double valor, String status) {
        this.id = id;
        this.cartao = cartao;
        this.mes = mes;
        this.ano = ano;
        this.tarja = tarja;
        this.valor = valor;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
