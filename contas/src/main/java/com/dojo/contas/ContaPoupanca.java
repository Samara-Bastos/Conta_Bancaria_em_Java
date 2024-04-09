package com.dojo.contas;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {
    private LocalDateTime diaUltimaAlteracao;
    private double juros = 0.05;

    public ContaPoupanca(double depositoInicial) {
        super(depositoInicial);
        this.diaUltimaAlteracao = LocalDateTime.of(2024,4,7, 10,15);
        if (depositoInicial < 50) {
            throw new RuntimeException("O valor do deposito inicial deve ser maior que 50,00 para a abertura da conta");
        }
    }

    public boolean sacarDinheiroPoupanca(double valor) {
        if(this.getSaldo() > 0 && valor > 0){
            super.sacar(valor);
            return true;
        }else{
            throw new RuntimeException("Saldo insuficiente para realizar o saque.");
        }
    }

    public boolean depositarDinheiroPoupanca(double valor) {
        if(valor > 0){
            super.depositar(valor);
            return true;
        }else{
            throw new RuntimeException("Não foi possivel realizar o deposito");
        }
    }

    private void aplicaJuros() {
        LocalDateTime hoje = LocalDateTime.now();
        
        if (!hoje.equals(this.diaUltimaAlteracao)) {
            long diferencaDias = ChronoUnit.DAYS.between(diaUltimaAlteracao, hoje);
            
            double montante = this.getSaldo() * Math.pow((1 + juros), diferencaDias); 

            this.setSaldo(montante);

            this.diaUltimaAlteracao = hoje;
        }
    }

    public boolean consultaSaldoPoupanca() {
        this.aplicaJuros();
        super.consultaSaldo();
        return true;
    }
}
