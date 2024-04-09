package com.dojo.contas;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private List<Conta> contas = new ArrayList<>();

    public Usuario(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    

}
