package br.com.caelum.serviçosDaConta;

import javax.swing.*;

public class SistemaInterno {

    public void login(Autenticavel a){
        int senha=0000; //Senha setada para não quebrar codigo enquanto raciocínio lógico
        boolean ok = a.autentica(senha);

        if(ok){
            JOptionPane.showMessageDialog(null,"Usuário logado");
        }else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha errado");
        }
    }
}
