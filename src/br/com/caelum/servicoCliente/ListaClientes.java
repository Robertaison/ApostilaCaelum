package br.com.caelum.servicoCliente;

import br.com.caelum.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {
    List<Cliente> clientes = new ArrayList<>();

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente getClienteIndex(int index){
        return clientes.get(index);
    }

    public String listarClientes(){
        String lista = "Clientes cadastrados: " + "\n" +
                       "--------------------" + "\n\n";
            for(int i = 0; i<clientes.size();i++){
                lista += "ID: " + (i + 1) + ". " + clientes.get(i).getNome() + " " + clientes.get(i).getSobrenome() + "\n";
            }
            lista+= "\n\n-------------------\n";
        return lista;
    }

    public void apagarCliente(int posicao){
        clientes.remove(posicao);
    }

    public boolean checarLista(){
        if(clientes.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public int getDimensao(){
        return clientes.size();
    }

    public void updateCliente(Cliente cliente, int index){
        clientes.remove(index);
        clientes.add(index, cliente);
    }
}
