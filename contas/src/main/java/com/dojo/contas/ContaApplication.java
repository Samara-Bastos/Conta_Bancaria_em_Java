package com.dojo.contas;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ContaApplication {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<>();
			
		Usuario usuario01 = new Usuario(contas);
		ContaCorrente cont1 = new ContaCorrente(1000);
		contas.add(cont1);

		ContaInvestimento contaIn = new ContaInvestimento(5000);
		contas.add(contaIn);

		System.out.println(usuario01.getSaldoTotal());
	}

}
