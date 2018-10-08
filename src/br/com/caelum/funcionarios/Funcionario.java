package br.com.caelum.funcionarios;

import br.com.caelum.serviçosDaConta.Data;
import br.com.caelum.serviçosFuncionarios.Autenticavel;
import br.com.caelum.serviçosFuncionarios.GerenciarCliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public abstract class Funcionario implements Autenticavel, Data {
	private String nome;
	private String cpf;
	private double salario;
	GerenciarCliente gerenciador;

	public Funcionario(String nome, String sobrenome, String cpf){
		setNome(nome + " " + sobrenome);
		setCpf(cpf);
		gerenciador = new GerenciarCliente();
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public double bonificacao(){
		return getSalario()*0.1;
	}

	@Override
	public boolean autentica(int senha) {
		return false;
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
					  "0. Sair" + "\n\n\n" +
					  "---------------------" + "\n" +
				      data();

		return funcionario;
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
