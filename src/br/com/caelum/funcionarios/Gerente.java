package br.com.caelum.funcionarios;

import br.com.caelum.serviçosFuncionarios.Autenticavel;

import javax.swing.JOptionPane;

public class Gerente extends Funcionario  {
	private int senha;
	private int numeroDeFuncionarios;

	public Gerente(String nome, String sobrenome, String cpf) {
		super(nome, sobrenome, cpf);
	}

	public boolean autentica(int senha) {
		if(senha==getSenha()) {
			JOptionPane.showMessageDialog(null, "Acesso confirmado");
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Acesso negado");
			return false;
		}
	}

	@Override
	public double bonificacao() {
		return super.bonificacao()*0.2;
	}

	private int getSenha() {
		return this.senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getBonificacao(){
		return super.getSalario()*1.4;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
