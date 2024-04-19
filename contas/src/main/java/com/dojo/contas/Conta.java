package com.dojo.contas;


public abstract  class Conta implements Operacoes {
    protected double saldo;

    public Conta(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    } 

    @Override
    public void sacar(double valor) {
        if(valor > this.saldo){
            throw new RuntimeException("Saldo insuficiente");
        }
        double novoSaldo = this.saldo -= valor;
        this.setSaldo(novoSaldo);
    } 

    @Override
    public void depositar(double valor) { 
        double novoSaldo = this.saldo += valor;
        this.setSaldo(novoSaldo);
    }


    @Override
    public void transferir(Conta conta, double valor) {
        this.sacar(valor);
        conta.depositar(valor);
        System.out.println("Transferência realizada com sucesso");
    }  

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + this.getSaldo() +
                '}';
    }
}
