package com.example.adilson.airlinetom.Model;

public class Aviao {
     private int id;
     private int capacidade;
     private String modelo;
     private String prefixo;

    public Aviao() {
    }

    public Aviao(int id, int capacidade, String modelo, String prefixo) {
        this.id = id;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.prefixo = prefixo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
}