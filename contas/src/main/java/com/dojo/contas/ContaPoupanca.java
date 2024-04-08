package com.dojo.contas;
import java.time.LocalDateTime;

public class ContaPoupanca extends Conta {
    private LocalDateTime dia;

    public ContaPoupanca(int numero, String agencia, double depositoInicial) {
        super(numero, agencia, depositoInicial);
        if (depositoInicial < 50) {
            throw new RuntimeException("O valor do deposito inicial deve ser maior que 50");
        }
    }

    @Override
    public boolean deposito(double valor) {
        return false;
    } 

    public boolean sacarDinheiroPoupanca(double valor) {
        if(this.getSaldo() > 0){
            super.sacar(valor);
            return true;
        }else{
            System.out.println("Saldo insuficiente para realizar o saque.");
            return false;
        }
    }
}
