package br.com.caelum.funcionarios;

import br.com.caelum.serviçosDaConta.CadastroClientes;
import br.com.caelum.serviçosDaConta.ListaClientes;
import br.com.caelum.serviçosFuncionarios.FuncionarioDoSistema;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Funcionario implements FuncionarioDoSistema {
	private String nome;
	private String cpf;
	private double salario;
	private int senha = 1234;
	CadastroClientes cadastroClientes = new CadastroClientes();
	ListaFuncionarios listaFuncionarios;

	public Funcionario(String nome,  String cpf){
		setNome(nome);
		setCpf(cpf);
	}

	public void gerenciarCliente(ListaClientes clientes, int i){
		switch (i){
			case 1:
				clientes.listarClientes();
				break;
			case 2:
				cadastroClientes.cadastrarCliente(clientes);
				break;
			case 3:
				clientes.apagarCliente(i);
				cadastroClientes.cadastroClienteNoIndice(clientes, i);
				break;
			case 4:
				clientes.apagarCliente(i);
				break;
			case 5:
				break;
		}
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
		if(this.senha == senha){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		String funcionario;
		funcionario = "Nome: " + getNome() + "\n" +
					  "Cpf: " + getCpf() + "\n\n" +
					  "Salário: " + getSalario() + "\n" +
					  "Bonûs mensal: " + bonificacao() + "\n\n" +
					  "Digite" + "\n" +
				   	  "1. Gerenciar Clientes" + "\n\n" +
					  "0. Retornar ao menu anterior" + "\n\n\n" +
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
