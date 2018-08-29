package br.com.caelum.conta.modelo;
import javax.swing.JOptionPane;

public class Cliente {
	private String nome;
	private String Sobrenome;
	private String cpf;
	private int idade;
	
	public boolean validaCpf(String cpf) {
		if(cpf==getCpf()) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(getIdade()<=60) {
			if(validaCpf(cpf)) {
				setCpf(cpf);
			}
		}else if(getIdade()>60){
			setCpf(cpf);
		}else {
			JOptionPane.showMessageDialog(null, "Cpf invalido, digite o cpf correto para operação");
		}		
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
}
