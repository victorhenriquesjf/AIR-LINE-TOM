package com.example.adilson.airlinetom.Model;

import java.util.Date;

public class Voo {
    private int id;
    private Aviao aviao;
    private String dataVoo;
    private Aeroporto destino;
    private Aeroporto origem;
    private double valorPassagem;

    public Voo() {
    }

    public Voo(int id, Aviao aviao, String dataVoo, Aeroporto destino, Aeroporto origem, double valorPassagem) {
        this.id = id;
        this.aviao = aviao;
        this.dataVoo = dataVoo;
        this.destino = destino;
        this.origem = origem;
        this.valorPassagem = valorPassagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }
}