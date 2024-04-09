package com.dojo.contas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ContaInvestimento extends Conta {
    private LocalDateTime primeiroDeposito;

    public ContaInvestimento(double depositoInicial) {
        super(depositoInicial);
        this.primeiroDeposito = LocalDateTime.now();
        if (depositoInicial < 1000) {
            throw new RuntimeException("O valor do deposito inicial deve ser maior que 1000");
        }
    }

    public boolean saque(double valor) {
        LocalDateTime agora = LocalDateTime.now();
        long diasDesdePrimeiroDeposito = ChronoUnit.DAYS.between(primeiroDeposito, agora);;
        if (diasDesdePrimeiroDeposito < 1) {
            throw new RuntimeException("É permitido sacar somente após 1 dia do primeiro depósito");
        }
        if (valor > super.getSaldo()) {
            throw new RuntimeException("Não é possível sacar mais do que o saldo disponível");
        }
        super.sacar(valor);
        return true;
    }

    public double mostraSaldo() {
        LocalDateTime agora = LocalDateTime.of(2024,4, 11, 23, 59);
        long diasDesdePrimeiroDeposito = ChronoUnit.DAYS.between(primeiroDeposito, agora);
        double saldoAtualizado = super.consultaSaldo();
        System.out.println("conta dias:" + diasDesdePrimeiroDeposito);
        for (int i = 0; i < diasDesdePrimeiroDeposito; i++) {
            saldoAtualizado *= 1.10;
        }
        return saldoAtualizado;
    }


    public LocalDateTime getPrimeiroDeposito() {
        return primeiroDeposito;
    }

    public void setPrimeiroDeposito(LocalDateTime primeiroDeposito) {
        this.primeiroDeposito = primeiroDeposito;
    }

    public boolean deposito(double valor) {
        return false;
    }

}
