[14:15] Victor Hugo Ferreira Silva
# Usuario
- nome: String
- cpf: String
- idade: int
- Conta:
- ContaInvestimento:
- contas: List<Conta>
- consultaSaldoTotal(): double
 
# Conta (Abstrata)
- numero: int
- agencia: String
- saldo: double
- primeiroDeposito: LocalDateTime
- deposito(valor: double): boolean
- saque(valor: double): boolean
- consulta(): double
 
# ContaCorrente (Concreta)
 
 
# ContaPoupança (Concreta)
 
 
# ContaInvestimento (Concreta)
contaInvestimento(valor: double > 1000, primeiroDeposito: LocalDateTime.now()): ContaInvestimento
* Saldo aumenta 10% por dia