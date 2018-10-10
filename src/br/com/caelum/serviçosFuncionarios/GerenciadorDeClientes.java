package br.com.caelum.serviçosFuncionarios;

import br.com.caelum.cliente.Cliente;
import br.com.caelum.servicoCliente.ListaClientes;


public interface GerenciadorDeClientes {
    public void addCliente(ListaClientes cliente, Cliente clientes);
    public String listaCliente(ListaClientes clientes);
    public void atualizaCliente(ListaClientes lista, int index);
    public void removeCliente(Cliente cliente);
}
