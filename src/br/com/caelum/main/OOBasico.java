
package br.com.caelum.main;
import javax.swing.JOptionPane;

import br.com.caelum.conta.Cliente;
import br.com.caelum.funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;




public class OOBasico {

	public static void main(String[] args) {
        int op=3;
        int op1=5;
        int op2=5;
        int op3=5;

        List<Cliente> clientes = new ArrayList<Cliente>();
        List<Funcionario> funcionarios = new ArrayList<>();
        String listaClientes= "";
        int cliente;

        while(op!=0){
            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite uma opção." +
                             "\n----------------\n\n" +
                             "1. Cliente\n" +
                             "2. Funcionário\n" +
                             "\n-----------------\n"+
                             "0. Sair do  programa"));

            switch (op){
                case 1:
                    while(op1!=0) {
                        op1 = Integer.parseInt(JOptionPane.showInputDialog("1. Para acesssar a conta\n" +
                                "2. Para criar a nova conta\n\n" +
                                "0. sair"));
                        if (op1 == 1) {
                            if (clientes.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Não tem clientes cadastrados.");
                            } else {
                                for (int i = 0; i < clientes.size(); i++) {
                                    listaClientes += (i + 1) + ". " + clientes.get(i).getNome() + " " + clientes.get(i).getSobrenome() + "\n";
                                }
                                while (op2 != 0) {
                                    op2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha sua conta: " +
                                            "\n-----------------\n\n" +
                                            listaClientes +
                                            "\n\n-----------------\n" +
                                            "0. Para sair"));
                                    if(op2!=0){
                                        cliente = op2 - 1;
                                        if (clientes.get(cliente).validaCpf(JOptionPane.showInputDialog("Digite seu cpf, apenas números."))) {
                                            while (op3 != 0) {
                                                op3 = Integer.parseInt(JOptionPane.showInputDialog(null, clientes.get(cliente)));
                                                if (op3 == 1) {
                                                    //contaCorrente
                                                    clientes.get(cliente).getContaCorrente().Menu();
                                                } else if (op3 == 2) {
                                                    //contaPoupança
                                                    clientes.get(cliente).getContaPoupanca().Menu();
                                                } else if(op3 == 3){
                                                    //seguro de vida
                                                }else if (op3 == 0) {
                                                    JOptionPane.showMessageDialog(null, "Retornando ao menu anterior.");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Digite uma opção correta");
                                                }
                                            }
                                        }
                                    }
                                    else if(op2==0){
                                        JOptionPane.showMessageDialog(null, "Retornando ao menu anterior.");
                                    } else{
                                        JOptionPane.showMessageDialog(null, "Cpf inválido, digite o cpf vaálido  do usuário " +
                                                clientes.get(op - 1).getNome() + " " +
                                                clientes.get(op - 1).getSobrenome());
                                    }
                                }
                            }

                        } else if (op1 == 2) {
                            String nome = JOptionPane.showInputDialog("Digite seu primeiro nome.");
                            if (nome.equals("")) {
                                nome = "error";
                            }
                            String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome");
                            if (sobrenome.equals("")) {
                                sobrenome = "error";
                            }
                            String cpf = JOptionPane.showInputDialog("Digite seu cpf");
                            if (cpf.equals("")) {
                                cpf = "error";
                            }
                            String age = JOptionPane.showInputDialog("Digite sua idade");
                            int idade;
                            if (age.equals("")) {
                                idade = 0;
                            } else {
                                idade = Integer.parseInt(age);
                            }
                            int confirmar = 0;
                            if (nome.equals("error") || sobrenome.equals("error") || cpf.equals("error") || idade == 0) {
                                JOptionPane.showMessageDialog(null, "Preencha corretamente os campos");
                                confirmar = 2;
                            }
                            while (confirmar != 1) {
                                String opcao = JOptionPane.showInputDialog("Confirme seus dados: " +
                                        "\n-------------------\n\n" +
                                        "Nome: " + nome + " " + sobrenome + "\n" +
                                        "Idade: " + idade + "\n\n" +
                                        "Cpf: " + cpf + "\n" +
                                        "\n-------------------\n" +
                                        "Digite:\n1. Confirmar     2. Editar\n" +
                                        "0. Sair");
                                if (opcao.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Digite um valor correto" +
                                            ".\n0. Sair");
                                } else {
                                    confirmar = Integer.parseInt(opcao);
                                }


                                if (confirmar == 1 && !nome.equals("error") && !sobrenome.equals("error") && !cpf.equals("error")) {
                                    Cliente novo = new Cliente(nome, sobrenome, cpf, idade);
                                    if (novo.getCpf() != null) {
                                        clientes.add(novo);
                                        JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
                                    }
                                } else if (confirmar == 2) {
                                    nome = JOptionPane.showInputDialog("Digite seu primeiro nome.");
                                    if (nome.equals("")) {
                                        nome = "error";
                                    }
                                    sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome");
                                    if (sobrenome.equals("")) {
                                        sobrenome = "error";
                                    }
                                    cpf = JOptionPane.showInputDialog("Digite seu cpf");
                                    if (cpf.equals("")) {
                                        cpf = "error";
                                    }
                                    age = JOptionPane.showInputDialog("Digite sua idade");
                                    if (age.equals("")) {
                                        idade = 0;
                                    } else {
                                        idade = Integer.parseInt(age);
                                    }
                                    if (nome.equals("error") || sobrenome.equals("error") || cpf.equals("error") || idade == 0) {
                                        JOptionPane.showMessageDialog(null, "Preencha corretamente os campos");
                                        confirmar = 2;
                                    }
                                } else if(confirmar==0) {
                                    JOptionPane.showMessageDialog(null,"Retornando ao menu.");
                                    confirmar=1;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Os dados estão errados, corrija.");
                                    confirmar=2;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    //implementar
                    break;
            }
        }

	}

}
