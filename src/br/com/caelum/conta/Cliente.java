package br.com.caelum.conta;
import javax.swing.JOptionPane;

public class Cliente {
	private String nome;
	private String Sobrenome;
	private String cpf;
	private int idade;

	public Cliente(String nome, String sobrenome, String cpf, int idade) {
		setNome(nome);
		setSobrenome(sobrenome);
		validarIdade(idade, cpf);
	}

	private void validarIdade(int idade, String cpf) {
		if(idade>=18) {
			setCpf(cpf);
			setIdade(idade);
		}else {
			JOptionPane.showMessageDialog(null,  "Não é possível criar a conta, apenas maiores de 18 anos.");
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
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean validaCpf(String cpf) {
		if(cpf==getCpf()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		String cliente = "Bem vindo ao Banco do Taison" +
						 "----------------------------\n\n" +
						 "Nome: " + getNome() + " " + getSobrenome() + "\n" +
						 "Idade " + getIdade() + ", Cpf " + getCpf() +	"\n\nAcessar:\n" +
						 "1. Conta Corrente" + "\n" +
						 "2. Conta Poupança" + "\n\n" +
						 "0. Sair";

		return cliente;
	}
}
