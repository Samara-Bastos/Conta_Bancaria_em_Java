package com.dojo.contas;

public class ContaCorrente extends Conta {

    public ContaCorrente(double saldo) {
        super(saldo);
    }

   public boolean saque(double valor) {
        double calcSaldo = getSaldo() - valor;
        if ( calcSaldo < -500  ) {
            throw new RuntimeException("Saldo insuficiente para saque");

        }
        super.sacar(valor);
        return true;
    }

    public double mostraSaldo(){
        return getSaldo();
    }

    public boolean deposito(double valor) {
        return false;
    }
}
