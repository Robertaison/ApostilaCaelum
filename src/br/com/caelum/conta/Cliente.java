package br.com.caelum.conta;
import br.com.caelum.serviçosDaConta.Data;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Cliente implements Data {
	private String nome;
	private String Sobrenome;
	private String cpf;
	private int idade;
	private static int numero = 0;
	ContaCorrente conta;

	public Cliente(String nome, String sobrenome, String cpf, int idade) {
		setNome(nome);
		setSobrenome(sobrenome);
		validarIdade(idade, cpf);
		numero++;
		conta = new ContaCorrente(getNome() + " " + getSobrenome(), getNumero());
	}

	public static int getNumero() {
		return numero;
	}

	public boolean validarIdade(int idade, String cpf) {
		if(idade>=18) {
			setCpf(cpf);
			setIdade(idade);
			return true;
		}else {
			JOptionPane.showMessageDialog(null,
					getNome() +
							 ", desculpe mas não foi possível criar sua conta. Apenas para maiores de 18 anos o serviço.");
			return false;
		}
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
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
		if(cpf.equals(getCpf())) {
			return true;
		}else {
			return false;
		}
	}

	public ContaCorrente getConta() {
		return conta;
	}

	@Override
	public String toString() {
		String cliente = "Bem vindo ao Banco do Taison" +
						 "----------------------------\n\n" +
						 "Nome: " + getNome() + " " + getSobrenome() + "\n" +
						 "Idade " + getIdade() + ", Cpf " + getCpf() +	"\n\nAcessar:\n" +
						 "1. Conta Corrente" + "\n" +
						 "2. Conta Poupança" + "\n" +
				         "3. Consultar seguro de vida" + "\n\n" +
						 "0. Sair" + "\n\n" +
						 "----------------------------\n" +
						 data();

		return cliente;
	}

	@Override
	public String data() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT)
				.withLocale(new Locale("pt", "br"));
		return agora.format(formatador);
	}
}
