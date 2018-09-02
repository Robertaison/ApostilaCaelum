package br.com.caelum.funcionarios;

public abstract class Funcionario {
	private String nome;
	private String cpf;
	private double salario;

	public double getSalario() {
		return salario;
	}

	public abstract double getBonificacao();
}
