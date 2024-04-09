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

    @Override
    public boolean cambioContas(Conta conta, double valor) {
        if (valor > conta.getSaldo()) {
            throw new RuntimeException("Transferência não permitida, saldo insuficiente");
        }
        double saldoAposEnvio = conta.getSaldo() - valor;
        conta.setSaldo(saldoAposEnvio);
        double novoSaldo = valor + this.getSaldo();
        this.setSaldo(novoSaldo);
        return true;
    }
}
