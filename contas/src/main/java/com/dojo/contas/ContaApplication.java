package com.dojo.contas;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ContaApplication {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<>();
			
		Usuario usuario01 = new Usuario(contas);
		ContaCorrente contC = new ContaCorrente(1000);
		contas.add(contC);
		ContaInvestimento contaIn = new ContaInvestimento(1000);
		contas.add(contaIn);

		contaIn.transferir(contC,contaIn.getSaldo());
		contC.sacar(contC.getSaldo()+450);

		
		
		System.out.println("\n Essas são as contas do usuario: \n"+contas);

	} 

}
