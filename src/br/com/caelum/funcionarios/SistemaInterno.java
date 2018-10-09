package br.com.caelum.funcionarios;

import br.com.caelum.serviçosFuncionarios.Autenticavel;

import javax.swing.*;

public class SistemaInterno {

    public boolean login(Autenticavel funcionario){
        int senha=Integer.parseInt(JOptionPane.showInputDialog("Digite a senha de login"));

        boolean ok = funcionario.autentica(senha);

        if(ok){
            JOptionPane.showMessageDialog(null,"Usuário logado");
        }else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha errado");
        }
        return ok;
    }
}
