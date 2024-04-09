package com.dojo.contas;

import java.util.ArrayList;
import java.util.List;
import com.dojo.contas.Conta;

public class Usuario {

    private List<Conta> listaContas = new ArrayList<>();

    public Usuario(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public List<Conta> getContas() {
        return listaContas;
    }

    public Double getSaldoTotal(){
        double total = 0.0;
        for (Conta listaContasSaldoTotal : listaContas) {
          total += listaContasSaldoTotal.getSaldo();
        }
        System.out.println("Esse é o total de todas as suas contas "+total);
        return total;
    }

    public void removerContaUsuario(Conta conta){
        if(conta instanceof ContaPoupanca || conta instanceof ContaInvestimento){

            boolean existeContaCorrente = false;
            Conta contaC;

            for (Conta c : listaContas) {
                if(c instanceof ContaCorrente){
                    contaC = c;
                    contaC.depositar(conta.getSaldo());
                    existeContaCorrente = true;
                    break;
                }
            }

            conta.sacar(conta.getSaldo());

            if(!existeContaCorrente){
                throw new RuntimeException("Não é possivel transferir o saldo, pois não existe uma conta corrente");
            }

            getContas().remove(conta);
        }else{
            throw new RuntimeException("Não é possivel remover uma conta corrente");
        }
    }
}
