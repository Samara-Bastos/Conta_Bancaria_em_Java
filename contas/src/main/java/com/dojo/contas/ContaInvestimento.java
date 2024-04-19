package com.dojo.contas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaInvestimento extends Conta {
    private LocalDate primeiroDeposito;
    private LocalDate novaData;
    private double juros = 0.10;
    public LocalDate agora = LocalDate.now();
 
    public ContaInvestimento(double depositoInicial) {
        super(depositoInicial);
        this.primeiroDeposito = LocalDate.now().minusDays(2);
        this.novaData = this.primeiroDeposito;

        if (depositoInicial < 1000) {
            throw new RuntimeException("O valor do deposito inicial deve ser maior que 1000");
        }
    }

    @Override
    public double getSaldo() {
        if (calculaDiferencaDias() > 0) {
            aplicarJuros();
        }
        return this.saldo;
    }

    @Override
    public void sacar(double valor) { 
        long diasDesdePrimeiroDeposito = ChronoUnit.DAYS.between(primeiroDeposito, agora);

        if (diasDesdePrimeiroDeposito < 1) {
            throw new RuntimeException("É permitido sacar somente após 1 dia do primeiro depósito");
        }
        if (valor > this.getSaldo()) {
            throw new RuntimeException("Não é possível sacar, saldo insuficiente");
        }
        double novoSaldo = this.saldo -= valor;
        this.setSaldo(novoSaldo);

        System.out.println("Saque de " + valor + " realizado com sucesso.");
    }    

    public void aplicarJuros() {
        double montante = this.saldo* Math.pow((1 + juros), calculaDiferencaDias()); 
        this.setSaldo(montante);
        this.novaData = agora;
    } 

    public long calculaDiferencaDias(){
        long diferencaDias = ChronoUnit.DAYS.between(novaData, agora);
        return diferencaDias;
    }

}
