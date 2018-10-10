package br.com.caelum.funcionarios;

import br.com.caelum.serviçosFuncionarios.CadastroFuncionários;
import br.com.caelum.serviçosFuncionarios.ListaFuncionarios;

import javax.swing.JOptionPane;

public class Gerente extends Funcionario  {
	private int senha=12345;
	private int numeroDeFuncionarios;
	CadastroFuncionários cadastroFuncionários = new CadastroFuncionários();



	public Gerente() {
		super("Gerente do Banco Taison", "000.000.400-20", 34);
	}

	public boolean autentica(int senha) {
		if(senha==getSenha()) {
			return true;
		}else {
			return false;
		}
	}

	public void gerenciarFuncionario(ListaFuncionarios funcionarios){
		int i = 6;
		while (i!=0){
			i = Integer.parseInt(JOptionPane.showInputDialog("O que gostaria de fazer: " + "\n\n" +
					"1. Listar os funcionários" + "\n" +
					"2. Adicionar funcionários" + "\n" +
					"3. Atualizar funcionários por id" + "\n" +
					"4. Remover funcionários por id" + "\n" +
					"5. Pesquisar funcionários por id" + "\n\n" +
					"0. Retornar ao funcionários anterior."));
			switch (i) {
				case 1:
					if (funcionarios.checarLista()) {
						JOptionPane.showMessageDialog(null, "Não há funcionários cadastrados");
					} else {
						JOptionPane.showMessageDialog(null, funcionarios.listarFuncinario());
					}
					break;
				case 2:
					cadastroFuncionários.cadastrarFuncionario(funcionarios);
					break;
				case 3:
					funcionarios.deletarFuncionario(i);
					cadastroFuncionários.cadastroFuncionarioNoIndice(funcionarios, i);
					break;
				case 4:
					int index1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário:"));
					funcionarios.deletarFuncionario(index1 - 1);
					break;
				case 5:
					int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionário:"));
					JOptionPane.showMessageDialog(null, "Cliente :" + funcionarios.getFuncionario(index - 1).getNome() + "\n" +
							"Idade: " + funcionarios.getFuncionario(index - 1).getIdade() + "      . " +
							"Cpf: " + funcionarios.getFuncionario(index - 1).getCpf() + "\n");
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
