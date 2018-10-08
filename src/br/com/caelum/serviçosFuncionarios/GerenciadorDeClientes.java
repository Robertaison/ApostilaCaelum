package br.com.caelum.serviçosFuncionarios;

import br.com.caelum.conta.Cliente;

import java.util.List;

public interface GerenciadorDeClientes {
    public void addCliente(List<Cliente> cliente, Cliente clientes);
    public String listaCliente(List<Cliente> clientes);
    public void atualizaCliente(Cliente cliente);
    public void removeCliente(Cliente cliente);
}
