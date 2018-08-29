package br.com.caelum.conta;
import javax.swing.JOptionPane;

/**
 * Classe responsável por estruturar uma conta bancária
 *
 * @author Robertson Souza
 */
public class Conta {
	private int numero;
	private Cliente titular = new Cliente();
	private double saldo;
	private int limite = 1000000;
	private static int totalDeContas = 0;
	private int indicadorConta = 0;
	private Data dataAbertura = new Data(27, 8, 2018);

	public Conta() {
	}

	public Conta(String titular, int numero, int dia, int mes, int ano) {
		setTitular(titular);
		setTotalDeContas(getTotalDeContas() + 1);
		setIndicadorConta(getTotalDeContas());
		setDataAbertura(dia, mes, ano);
	}

	public Conta(String titular, int numero, double deposita, int dia, int mes, int ano) {
		this(titular, numero, dia, mes, ano);
		deposita(deposita);
	}

	public void setIndicadorConta(int indicadorConta) {
		this.indicadorConta = indicadorConta;
	}
	
	 /**
     * Metodo que retorna numero que representa conta em ordem de criação
     */
	public int getIndicadorConta() {
		return this.indicadorConta;
	}
	
	/**
     * Metodo que retorna rendimento do saldo com taxa de 10%
     */
	public double redimento() {
		double rendimento = getSaldo() * 0.1;
		return rendimento;
	}

	public static void setTotalDeContas(int totalDeContas) {
		Conta.totalDeContas = totalDeContas;
	}

	/**
     * Metodo que retorna quantidade de contas existentes no sistema
     */
	public static int getTotalDeContas() {
		return totalDeContas;
	}

	public int getNumero() {
		return numero;
	}

	
	/**
     * Metodo que retorna o nome do titular
     */
	public String getTitular() {
		return titular.getNome();
	}
	
	/**
     * Metodo que faz atualizações ao nome do titular
     * @param nome tipo String que representa a alterção a ser feita no nome do titular
     */
	public void setTitular(String nome) {
		this.titular.setNome(nome);
	}
	
	/**
     * Sobrecarga do metodo com opção de alterar sobrenome
     * @param sobrenome tipo String que represena a alteração que o sobrenome do titular recebera
     */
	public void setTitular(String nome, String sobrenome) {
		this.titular.setNome(nome);
		this.titular.setSobrenome(sobrenome);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
     * Metodo para deposito de valores
     * @param valor tipo double que sera depositado a conta
     */
	public void deposita(double valor) {
		if (valor > 0 && valor <= limite) {
			this.setSaldo(this.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Deu bom " + titular.getNome() + ".\nSaldo atual de: " + getSaldo());
		} else {
			JOptionPane.showMessageDialog(null, "Quer depositar o que com esse valor fião?");
		}
	}
	
	/**
     * Metodo responsável por saque na conta
     * @param valor tipo double que sera sacado
     */
	public void saque(double valor) {
		if (valor > this.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Valor solicitado para saque maior que saldo em conta");
		} else {
			this.setSaldo(this.getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Ultimo saque de: " + valor + "\nSaldo atual: " + this.getSaldo());
		}
	}
	
	/**
     * Metodo responsável por transferência entre contas
     * @param destino tipo Conta que receberá o valor
     * @param valor decimal que será transferido
     */
	public void transfere(Conta destino, double valor) {
		if (valor > this.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Valor solicitado para transferência maior que saldo em conta");
		} else {
			this.setSaldo(getSaldo() - valor);
			destino.setSaldo(destino.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Transferência de: " + valor + "\nSaldo atual: " + this.getSaldo());
		}
	}

	@Override
	public String toString() {
		String conta = "Titular: " + titular.getNome() + "\nNúmero: " + getNumero() + "\nSaldo: " + getSaldo();
		return conta;
	}
	
	/**
	 * Metodo que retorna data de abertura da conta
	 */
	public Data getDataAbertura() {
		return dataAbertura;
	}
	
	/**
	 * Medo responsável para alterações a data de abertura
	 * @param dia tipo int que representa o dia da abertura
	 * @param mes tipo int que representa o mes da abertura
	 * @param ano tipo int que representa o ano da abertura
	 */
	public void setDataAbertura(int dia, int mes, int ano) {
		dataAbertura.setDia(dia);
		dataAbertura.setMes(mes);
		dataAbertura.setAno(ano);
	}
}
