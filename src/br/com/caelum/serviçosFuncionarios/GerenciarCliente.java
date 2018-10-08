package br.com.caelum.serviçosFuncionarios;

import br.com.caelum.conta.Cliente;

import java.util.List;

public class GerenciarCliente implements GerenciadorDeClientes {

    @Override
    public void addCliente(List <Cliente> clientes, Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public String listaCliente(List<Cliente> clientes) {
        String lista = "";
        if (!clientes.isEmpty()){
            for(int i = 0; i<clientes.size(); i++){
                lista += (i + 1) + ". " + clientes.get(i).getNome() + " " + clientes.get(i).getSobrenome() + "\n";
            }
        }else{
            lista += "Não há clientes cadastrados";
        }
        return lista;
    }

    @Override
    public void atualizaCliente(Cliente cliente) {

    }

    @Override
    public void removeCliente(Cliente cliente) {

    }
}
