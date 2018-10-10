package br.com.caelum.serviçosDaConta;
import javax.swing.JOptionPane;

/**
 * Interface responsável por estruturar uma conta bancária
 *
 * @author Robertson Souza
 */
public interface Conta {
	public double getSaldo();
	public void deposita(double valor);
	public void saca(double valor);
	public void Menu();
}
