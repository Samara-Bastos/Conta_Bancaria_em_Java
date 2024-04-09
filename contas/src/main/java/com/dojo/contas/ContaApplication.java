package com.dojo.contas;

import com.dojo.contas.Conta;
import com.dojo.contas.ContaInvestimento;
import com.dojo.contas.ContaPoupanca;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;

@SpringBootApplication
public class ContaApplication {

	public static void main(String[] args) {

		ContaPoupanca contaP = new ContaPoupanca(100.00);
		System.out.println();

		boolean consultandoSaldo = contaP.consultaSaldoPoupanca();

		if(consultandoSaldo){
			System.out.println(contaP);
		}

	}

}
