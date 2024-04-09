package com.dojo.contas;


public abstract  class Conta {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double novoSaldo) {
        saldo = novoSaldo;
    }

    public void sacar(double valor) {
        saldo -= valor;
        System.out.println("Saque de " + valor + " realizado com sucesso.");
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Deposito de " + valor + " realizado com sucesso.");
    }

    public Conta(double saldo){
        this.saldo = saldo;
    }

    public double consultaSaldo(){
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }
}
