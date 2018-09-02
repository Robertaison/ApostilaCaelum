package br.com.caelum.funcionarios;

import javax.swing.JOptionPane;

public class Gerente extends Funcionario{
	protected int senha;
	protected int numeroDeFuncionarios;
	
	public boolean login(int senha) {
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
