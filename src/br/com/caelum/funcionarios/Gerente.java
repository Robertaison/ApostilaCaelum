package br.com.caelum.funcionarios;

import br.com.caelum.serviçosDaConta.Autenticavel;

import javax.swing.JOptionPane;

public class Gerente extends Funcionario implements Autenticavel {
	private int senha;
	private int numeroDeFuncionarios;
	
	public boolean autentica(int senha) {
		if(senha==getSenha()) {
			JOptionPane.showMessageDialog(null, "Acesso confirmado");
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Acesso negado");
			return false;
		}
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
}
