package com.dojo.contas;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {
    private double juros = 0.05;
    private LocalDate novaData;
    public LocalDate hoje = LocalDate.now();

    public ContaPoupanca(double depositoInicial) {
        super(depositoInicial);
        this.novaData = LocalDate.now().minusDays(2);
        if (depositoInicial < 50) {
            throw new RuntimeException("O valor do deposito inicial deve ser maior que 50,00 para a abertura da conta");
        }
    }

    @Override
    public double getSaldo() {
        if(calculaDiferencaDias() > 0){
            aplicaJuros();
        }
        return this.saldo;
    }

    private void aplicaJuros() {
        double montante = this.saldo * Math.pow((1 + juros), calculaDiferencaDias()); 
        this.setSaldo(montante);
        this.novaData = hoje;
    }

    public long calculaDiferencaDias(){
        long diferencaDias = ChronoUnit.DAYS.between(novaData, hoje);
        return diferencaDias;
    }
}
