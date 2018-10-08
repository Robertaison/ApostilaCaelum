package br.com.caelum.serviçosFuncionarios;

import br.com.caelum.conta.Cliente;
import br.com.caelum.serviçosDaConta.CadastroClientes;
import br.com.caelum.serviçosDaConta.ListaClientes;

import java.util.List;

public class GerenciarCliente implements GerenciadorDeClientes {

    CadastroClientes cadastrar = new CadastroClientes();

    @Override
    public void addCliente(ListaClientes clientes, Cliente cliente) {
        clientes.addCliente(cliente);
    }

    @Override
    public String listaCliente(ListaClientes clientes) {
        String lista = "";
        if (!clientes.checarLista()){
            for(int i = 0; i<clientes.getDimensao(); i++){
                lista += (i + 1) + ". " + clientes.getClienteIndex(i).getNome() + " " + clientes.getClienteIndex(i).getSobrenome() + "\n";
            }
        }else{
            lista += "Não há clientes cadastrados";
        }
        return lista;
    }

    @Override
    public void atualizaCliente(ListaClientes lista, int index) {
        cadastrar.cadastroClienteNoIndice(lista, index);
    }

    @Override
    public void removeCliente(Cliente cliente) {

    }
}
