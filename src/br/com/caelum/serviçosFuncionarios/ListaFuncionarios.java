package br.com.caelum.serviçosFuncionarios;

import br.com.caelum.funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ListaFuncionarios {
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void updateFuncioario(Funcionario funcionario, int index){
        funcionarios.remove(index);
        funcionarios.add(index, funcionario);
    }

    public void deletarFuncionario(int index){
        funcionarios.remove(index);
    }

    public String listarFuncinario(){
        String lista = "Funcionários ativos: " + "\n" +
                       "-------------------\n\n";
        for(int i = 0; i<funcionarios.size();i++){
            lista += (i + 1) + ". " + funcionarios.get(i).getNome() +  "\n";
        }
        lista+=   "\n\n-------------------\n";
        return lista;
    }


    public boolean checarLista(){
        if(funcionarios.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public Funcionario getFuncionario(int index){
        return funcionarios.get(index);
    }

    public int getDimensao(){
        return funcionarios.size();
    }
}
