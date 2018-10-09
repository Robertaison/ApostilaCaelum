package br.com.caelum.funcionarios;

import br.com.caelum.serviçosFuncionarios.Autenticavel;

import javax.swing.JOptionPane;

public class Gerente extends Funcionario  {
	private int senha=12345;
	private int numeroDeFuncionarios;
	ListaFuncionarios listaFuncionarios = new ListaFuncionarios();


	public Gerente() {
		super("Gerente do Banco Taison", "000.000.400-20");
	}

	public boolean autentica(int senha) {
		if(senha==getSenha()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public double bonificacao() {
		return super.bonificacao()*0.2;
	}

	@Override
	public double getSalario() {
		return 9000.00;
	}

	private int getSenha() {
		return this.senha;
	}

	@Override
	public String toString() {
		String funcionario;
		funcionario = "Nome: " + getNome() + "\n" +
				"Cpf: " + getCpf() + "\n\n" +
				"Salário: " + getSalario() + "\n" +
				"Bonûs mensal: " + bonificacao() + "\n\n" +
				"Digite" + "\n" +
				"1. Gerenciar Clientes" + "\n" +
				"2. Gerenciar Funcionários" + "\n\n" +
				"0. Retornar ao menu anterior" + "\n\n\n" +
				"---------------------" + "\n" +
				data();

		return funcionario;
	}
}
