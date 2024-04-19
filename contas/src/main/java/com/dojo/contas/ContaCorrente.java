package com.dojo.contas;

public class ContaCorrente extends Conta {

    public ContaCorrente(double saldo) {
        super(saldo);
    } 

    @Override
   public void sacar(double valor) {
        double calcSaldo = getSaldo() - valor;
        if ( calcSaldo < -500  ) {
            throw new RuntimeException("Saldo insuficiente para saque");

        }
        double novoSaldo = this.saldo -= valor;
        this.setSaldo(novoSaldo);
        System.out.println("Saque de " + valor + " realizado com sucesso.");
    } 

}
