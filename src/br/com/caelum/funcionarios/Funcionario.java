package br.com.caelum.funcionarios;

import br.com.caelum.servicoCliente.CadastroClientes;
import br.com.caelum.servicoCliente.ListaClientes;
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
	private int idade;
	CadastroClientes cadastroClientes = new CadastroClientes();

	public Funcionario(String nome,  String cpf, int idade){
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public void gerenciarCliente(ListaClientes clientes){
		int i = 6;
		while (i!=0){
			 i = Integer.parseInt(JOptionPane.showInputDialog("O que gostaria de fazer: " + "\n\n" +
					"1. Listar os clientes." + "\n" +
					"2. Adicionar cliente" + "\n" +
					"3. Atualizar cliente por id" + "\n" +
					"4. Remover cliente por id" + "\n" +
					"5. Pesquisar cliente por id" + "\n\n" +
					"0. Retornar ao menu anterior."));
			switch (i) {
				case 1:
					if (clientes.checarLista()) {
						JOptionPane.showMessageDialog(null, "Não há funcionários cadastrados");
					} else {
						JOptionPane.showMessageDialog(null, clientes.listarClientes());
					}
					break;
				case 2:
					cadastroClientes.cadastrarCliente(clientes);
					break;
				case 3:
					clientes.apagarCliente(i);
					cadastroClientes.cadastroClienteNoIndice(clientes, i);
					break;
				case 4:
					int index1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário:"));
					clientes.apagarCliente(index1 - 1);
					break;
				case 5:
					int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário:"));
					JOptionPane.showMessageDialog(null, "Cliente :" + clientes.getClienteIndex(index - 1).getNome() + " " + clientes.getClienteIndex(i).getSobrenome() + "\n" +
							"Idade: " + clientes.getClienteIndex(index - 1).getIdade() + "      . " +
							"Cpf: " + clientes.getClienteIndex(index - 1).getCpf() + "\n");
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Retornando ao menu anterior");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Digite uma opção válida.");
					break;
			}
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
