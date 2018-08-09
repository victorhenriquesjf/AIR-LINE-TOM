package com.example.adilson.airlinetom.Model;

public class Poltrona {

    private int id;
    private String assento;
    private boolean ocupado;
    private Usuario usuario;

    public Poltrona() {
    }

    public Poltrona(int id, String assento, boolean ocupado, Usuario usuario) {
        this.id = id;
        this.assento = assento;
        this.ocupado = ocupado;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
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
}
