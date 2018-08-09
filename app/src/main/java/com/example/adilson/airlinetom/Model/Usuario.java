package com.example.adilson.airlinetom.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String email;
    private int id;
    private String login;
    private String nome;
    private String senha;
    private List<Passagem>passagens;
    private String idade;


    public Usuario(String email, int id, String login, String nome, String senha,String idade) {
        this.email = email;
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.passagens= new ArrayList<>();
    }

    public Usuario(String email, int id, String login, String nome, String senha) {
        this.email = email;
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;

    }


    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
}