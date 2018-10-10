
package br.com.caelum.main;
import javax.swing.JOptionPane;

import br.com.caelum.cliente.Cliente;
import br.com.caelum.funcionarios.Funcionario;
import br.com.caelum.funcionarios.Gerente;
import br.com.caelum.serviçosFuncionarios.ListaFuncionarios;
import br.com.caelum.funcionarios.SistemaInterno;
import br.com.caelum.servicoCliente.CadastroClientes;
import br.com.caelum.servicoCliente.ListaClientes;



public class OOBasico {

	public static void main(String[] args) {
        int op=3;
        int op2=5;
        int op3=5;


        CadastroClientes cadastro = new CadastroClientes();
        ListaClientes listaClientes = new ListaClientes();
        ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
        SistemaInterno acesso = new SistemaInterno();

        Cliente cliente1 = new Cliente("Jhon","jr", "800.300.700-30", 29);
        Cliente cliente2 = new Cliente("Kid","jr", "830.768.704-50", 27);
        Funcionario funcionario1 = new Funcionario("João Silva", "500.400.300-10", 25);
        Funcionario funcionario2 = new Funcionario("Amanda Silva", "400.500.200-10", 23);
        Gerente gerente = new Gerente();

        listaClientes.addCliente(cliente1);
        listaClientes.addCliente(cliente2);

        listaFuncionarios.addFuncionario(funcionario1);
        listaFuncionarios.addFuncionario(funcionario2);

        int indice;

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
                    int op1=5;
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
                    break;
                case 2:
                    int op5=5;
                    while (op5!=0){

                        op5 = Integer.parseInt(JOptionPane.showInputDialog("1. Funcionários" + "\n" +
                                                                           "2. Gerente" + "\n\n" +
                                                                           "0. Retornar ao menu anterior"));
                        if (op5==1){
                            while (op2!=0){
                                op2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha sua conta: " +
                                        "\n-----------------\n\n" +
                                        listaFuncionarios.listarFuncinario() +
                                        "\n\n-----------------\n" +
                                        "0. Para sair"));
                                if (op2!=0){
                                    indice=op-1;
                                    if(acesso.login(listaFuncionarios.getFuncionario(indice))){
                                        while (op3!=0){
                                            int opcao = Integer.parseInt(JOptionPane.showInputDialog(listaFuncionarios.getFuncionario(indice)));
                                            if(opcao == 1){
                                                listaFuncionarios.getFuncionario(indice).gerenciarCliente(listaClientes);
                                            }else if (opcao == 0){
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
                                int opcao = Integer.parseInt(JOptionPane.showInputDialog(gerente));
                                while (opcao!=0){
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
                    break;
            }
        }

	}

}
