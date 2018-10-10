package br.com.caelum.servicoCliente;

import br.com.caelum.cliente.Cliente;

import javax.swing.*;

public class CadastroClientes {
    public void cadastrarCliente(ListaClientes lista) {
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
                    lista.addCliente(novo);
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
            } else if (confirmar == 0) {
                JOptionPane.showMessageDialog(null, "Retornando ao menu.");
                confirmar = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Os dados estão errados, corrija.");
                confirmar = 2;
            }

        }
    }

    public void cadastroClienteNoIndice(ListaClientes lista, int index){
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
                    lista.updateCliente(novo, index);
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
            } else if (confirmar == 0) {
                JOptionPane.showMessageDialog(null, "Retornando ao menu.");
                confirmar = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Os dados estão errados, corrija.");
                confirmar = 2;
            }

        }
    }
}
