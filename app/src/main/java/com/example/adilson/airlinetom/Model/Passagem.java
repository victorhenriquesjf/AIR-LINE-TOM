package com.example.adilson.airlinetom.Model;

public class Passagem {
    private int id;
    private int assento;
    private boolean ocupado;
    private Usuario usuario;
    private String origem;
    private String destino;
    private String dataVoo;
    private String valorPassagem;


    public Passagem() {
    }


    public Passagem(int id, int assento, boolean ocupado, Usuario usuario, String origem, String destino, String dataVoo, String valorPassagem) {
        this.id = id;
        this.assento = assento;
        this.ocupado = ocupado;
        this.usuario = usuario;
        this.origem = origem;
        this.destino = destino;
        this.dataVoo = dataVoo;
        this.valorPassagem = valorPassagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(String valorPassagem) {
        this.valorPassagem = valorPassagem;
    }
}