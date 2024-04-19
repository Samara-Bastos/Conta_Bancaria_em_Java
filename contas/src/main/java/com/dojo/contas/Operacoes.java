package com.dojo.contas;

interface Operacoes {

    void sacar(double valor);
    void depositar(double valor);
    void transferir(Conta conta, double valor);
}