package com.dojo.contas;

import com.dojo.contas.Conta;
import com.dojo.contas.ContaInvestimento;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContaApplication {

	public static void main(String[] args) {

		Conta conta = new ContaPoupanca(1111111,"1020-9", 1000.00);
		
		System.out.println("Tudo bom ?");

	}

}
