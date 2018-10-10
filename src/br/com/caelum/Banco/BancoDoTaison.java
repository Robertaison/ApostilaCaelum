package br.com.caelum.Banco;

import br.com.caelum.funcionarios.Gerente;
import br.com.caelum.funcionarios.SistemaInterno;
import br.com.caelum.servicoCliente.CadastroClientes;
import br.com.caelum.servicoCliente.ListaClientes;
import br.com.caelum.serviçosFuncionarios.ListaFuncionarios;

import javax.swing.*;

public class BancoDoTaison {
    CadastroClientes cadastro = new CadastroClientes();
    SistemaInterno acesso = new SistemaInterno();

    public void menuCliente(ListaClientes listaClientes){
        int op=5;
        int op1=5;
        int op2=5;
        int op3=5;
        int indice;

        while(op1!=0) {
            op1 = Integer.parseInt(JOptionPane.showInputDialog("1. Para acesssar a conta\n" +
                    "2. Para criar a nova conta\n\n" +
                    "0. sair"));
            if (op1 == 1) {
                if (listaClientes.checarLista()) {
                    JOptionPane.showMessageDialog(null, "Não tem clientes cadastrados.");
                } else {
                    while (op2 != 0) {
                        op2 = Integer.parseInt(JOptionPane.showInputDialog(
                                listaClientes.listarClientes() +
                                        "0. Para sair"));
                        if(op2!=0){
                            indice = op2 - 1;
                            if (listaClientes.getClienteIndex(indice).validaCpf(JOptionPane.showInputDialog("Digite seu cpf, apenas números."))) {
                                while (op3 != 0) {
                                    op3 = Integer.parseInt(JOptionPane.showInputDialog(null, listaClientes.getClienteIndex(indice)));
                                    if (op3 == 1) {
                                        //contaCorrente
                                        listaClientes.getClienteIndex(indice).getContaCorrente().Menu();
                                    } else if (op3 == 2) {
                                        //contaPoupança
                                        listaClientes.getClienteIndex(indice).getContaPoupanca().Menu();
                                    } else if(op3 == 3){
                                        //seguro de vida
                                    }else if (op3 == 0) {
                                        JOptionPane.showMessageDialog(null, "Retornando ao menu anterior.");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Digite uma opção correta");
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "O cpf digitado está incorreto");
                            }
                        }
                        else if(op2==0){
                            JOptionPane.showMessageDialog(null, "Retornando ao menu anterior.");
                        } else{
                            JOptionPane.showMessageDialog(null, "Cpf inválido, digite o cpf vaálido  do usuário " +
                                    listaClientes.getClienteIndex(op-1).getNome() + " " +
                                    listaClientes.getClienteIndex(op-1).getSobrenome());
                        }
                    }
                }

            } else if (op1 == 2) {
                cadastro.cadastrarCliente(listaClientes);
            }else if (op1 == 0){
                JOptionPane.showMessageDialog(null, "Retornando ao menu anterior.");
                op=5;
            }else{
                JOptionPane.showMessageDialog(null, "Digite uma opção válida.");
            }
        }
    }

    public void menuFuncionario(ListaFuncionarios listaFuncionarios, ListaClientes listaClientes, Gerente gerente){
        int op=5;
        int op2=5;
        int op3=5;
        int indice;
        int op5=5;
        while (op5!=0){

            op5 = Integer.parseInt(JOptionPane.showInputDialog("1. Funcionários" + "\n" +
                    "2. Gerente" + "\n\n" +
                    "0. Retornar ao menu anterior"));
            if (op5==1){
                while (op2!=0){
                    op2 = Integer.parseInt(JOptionPane.showInputDialog(
                            listaFuncionarios.listarFuncinario() +
                                    "0. Para sair"));
                    if (op2!=0){
                        indice=op2-1;
                        if(acesso.login(listaFuncionarios.getFuncionario(indice))){
                            while (op3!=0){
                                op3 = Integer.parseInt(JOptionPane.showInputDialog(listaFuncionarios.getFuncionario(indice)));
                                if(op3 == 1){
                                    listaFuncionarios.getFuncionario(indice).gerenciarCliente(listaClientes);
                                }else if (op3 == 0){
                                    JOptionPane.showMessageDialog(null,"Retornando ao menu anterior");
                                }else{
                                    JOptionPane.showMessageDialog(null,"Digite uma opção válida");
                                }
                            }
                        }
                    }else if(op2==0){
                        JOptionPane.showMessageDialog(null,"Retornando ao menu anterior");
                    }else{
                        JOptionPane.showMessageDialog(null,"Digite uma opção válida");
                    }
                }
            }else if(op5==2){
                if(acesso.login(gerente)){
                    int opcao = 6;
                    while (opcao!=0){
                        opcao = Integer.parseInt(JOptionPane.showInputDialog(gerente))
                        if (opcao==1){
                            gerente.gerenciarCliente(listaClientes);
                        }else if (opcao==2){
                            gerente.gerenciarFuncionario(listaFuncionarios);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Senha incorreta.");
                }
            }else if (op5==0){
                JOptionPane.showMessageDialog(null,"Retornando ao menu anterior");
                op=5;
            }else{
                JOptionPane.showMessageDialog(null,"Digite uma opção válida");
            }
        }
    }
}
