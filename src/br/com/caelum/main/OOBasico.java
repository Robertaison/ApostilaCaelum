
package br.com.caelum.main;
import javax.swing.JOptionPane;

import br.com.caelum.serviçosDaConta.CadastroClientes;
import br.com.caelum.serviçosDaConta.ListaClientes;



public class OOBasico {

	public static void main(String[] args) {
        int op=3;
        int op1=5;
        int op2=5;
        int op3=5;

        CadastroClientes cadastro = new CadastroClientes();
        ListaClientes lista = new ListaClientes();
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
                            if (lista.checarLista()) {
                                JOptionPane.showMessageDialog(null, "Não tem clientes cadastrados.");
                            } else {
                                while (op2 != 0) {
                                    op2 = Integer.parseInt(JOptionPane.showInputDialog("Escolha sua conta: " +
                                            "\n-----------------\n\n" +
                                            lista.listarClientes() +
                                            "\n\n-----------------\n" +
                                            "0. Para sair"));
                                    if(op2!=0){
                                        cliente = op2 - 1;
                                        if (lista.getClienteIndex(cliente).validaCpf(JOptionPane.showInputDialog("Digite seu cpf, apenas números."))) {
                                            while (op3 != 0) {
                                                op3 = Integer.parseInt(JOptionPane.showInputDialog(null, lista.getClienteIndex(cliente)));
                                                if (op3 == 1) {
                                                    //contaCorrente
                                                    lista.getClienteIndex(cliente).getContaCorrente().Menu();
                                                } else if (op3 == 2) {
                                                    //contaPoupança
                                                    lista.getClienteIndex(cliente).getContaPoupanca().Menu();
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
                                                lista.getClienteIndex(op-1).getNome() + " " +
                                                lista.getClienteIndex(op-1).getSobrenome());
                                    }
                                }
                            }

                        } else if (op1 == 2) {
                            cadastro.cadastrarCliente(lista);
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
