package com.example.adilson.airlinetom.Model;

public class Aeroporto {
    private int id;
    private String aeroporto;
    private String cidade;

    public Aeroporto() {
    }

    public Aeroporto(int id, String aeroporto, String cidade) {
        this.id = id;
        this.aeroporto = aeroporto;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}