package br.com.caelum.conta;

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
        String lista = "";
            for(int i = 0; i<clientes.size();i++){
                lista += (i + 1) + ". " + clientes.get(i).getNome() + " " + clientes.get(i).getSobrenome() + "\n";
            }
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
}
