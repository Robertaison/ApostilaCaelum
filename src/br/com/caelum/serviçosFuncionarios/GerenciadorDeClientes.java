package br.com.caelum.serviçosFuncionarios;

import br.com.caelum.conta.Cliente;
import br.com.caelum.serviçosDaConta.ListaClientes;


public interface GerenciadorDeClientes {
    public void addCliente(ListaClientes cliente, Cliente clientes);
    public String listaCliente(ListaClientes clientes);
    public void atualizaCliente(ListaClientes lista, int index);
    public void removeCliente(Cliente cliente);
}
