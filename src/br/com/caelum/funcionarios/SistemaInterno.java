package br.com.caelum.funcionarios;

import br.com.caelum.serviçosFuncionarios.Autenticavel;

import javax.swing.*;

public class SistemaInterno {

    public void login(Autenticavel a){
        int senha=0000; //Senha default
        boolean ok = a.autentica(senha);

        if(ok){
            JOptionPane.showMessageDialog(null,"Usuário logado");
        }else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha errado");
        }
    }
}
