
package br.com.caelum.main;
import javax.swing.JOptionPane;

import br.com.caelum.conta.Conta;
import br.com.caelum.conta.ContaCorrente;
import br.com.caelum.conta.ContaPoupanca;

import java.util.ArrayList;


public class OOBasico {

	public static void main(String[] args) {
        int op=3;

        while(op!=0){
            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite uma opção." +
                             "----------------\n\n" +
                             "1. Cliente\n" +
                             "2. Funcionário\n\n" +
                             "0. Sair do  programa" +
                             "-----------------\n\n"));

            switch (op){
                case 1:
                    op = Integer.parseInt(JOptionPane.showInputDialog("1. Para acesssar a conta\n" +
                                                                      "2. Para criar a nova conta\n\n" +
                                                                      "0. sair"));
                    if(op==1){

                    }
            }
        }

	}

}
