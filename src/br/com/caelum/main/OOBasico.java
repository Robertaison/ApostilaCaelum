
package br.com.caelum.main;
import javax.swing.JOptionPane;

import br.com.caelum.conta.Conta;
import br.com.caelum.conta.ContaCorrente;
import br.com.caelum.conta.ContaPoupanca;


public class OOBasico {

	public static void main(String[] args) {
		ContaPoupanca c1 = new ContaPoupanca("Ronin");
		JOptionPane.showMessageDialog(null, c1);
	}

}
