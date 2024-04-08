package com.dojo.contas;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public Usuario(String nome, String cpf, int idade, List<Conta> contas) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    private String nome;
    private String cpf;
    private int idade;
    private List<Conta> contas = new ArrayList<>();

}
