package com.dojo.contas;

import java.time.LocalDateTime;

public class ContaInvestimento extends Conta{
    private LocalDateTime primeiroDeposito;

    public ContaInvestimento(double depositoInicial) {
        super(depositoInicial);
        if (depositoInicial < 1000) {
            throw new RuntimeException("O valor do deposito inicial deve ser maior que 1000");
        }
    }

    public LocalDateTime getPrimeiroDeposito() {
        return primeiroDeposito;
    }

    public void setPrimeiroDeposito(LocalDateTime primeiroDeposito) {
        this.primeiroDeposito = primeiroDeposito;
    }

    public boolean consultaSaldoInvestimento() {
        super.consultaSaldo();
        return true;
    }
}
