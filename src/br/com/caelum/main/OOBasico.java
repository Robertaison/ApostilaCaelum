
package br.com.caelum.main;
import javax.swing.JOptionPane;

import br.com.caelum.Banco.BancoDoTaison;
import br.com.caelum.cliente.Cliente;
import br.com.caelum.funcionarios.Funcionario;
import br.com.caelum.funcionarios.Gerente;
import br.com.caelum.serviçosFuncionarios.ListaFuncionarios;
import br.com.caelum.servicoCliente.ListaClientes;



public class OOBasico {

	public static void main(String[] args) {
        int op=3;
        int op2=5;
        int op3=5;

        BancoDoTaison banco = new BancoDoTaison();

        ListaClientes listaClientes = new ListaClientes();
        ListaFuncionarios listaFuncionarios = new ListaFuncionarios();

        Cliente cliente1 = new Cliente("Jhon","jr", "800.300.700-30", 29);
        Cliente cliente2 = new Cliente("Kid","jr", "830.768.704-50", 27);
        Funcionario funcionario1 = new Funcionario("João Silva", "500.400.300-10", 25);
        Funcionario funcionario2 = new Funcionario("Amanda Silva", "400.500.200-10", 23);
        Gerente gerente = new Gerente();

        listaClientes.addCliente(cliente1);
        listaClientes.addCliente(cliente2);

        listaFuncionarios.addFuncionario(funcionario1);
        listaFuncionarios.addFuncionario(funcionario2);

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
                    banco.menuCliente(listaClientes);
                    break;
                case 2:
                    banco.menuFuncionario(listaFuncionarios,listaClientes,gerente);
                    break;
            }
        }

	}

}
