import javax.swing.JOptionPane;

public class Conta {
	private int numero;
	private Cliente titular = new Cliente();
	private double saldo;
	Data dataAbertura = new Data(27,8,2018);
	
	
	public double redimento() {
		double rendimento = getSaldo()*0.1;
		return rendimento;
	}
	
	
	public Conta(String titular, int numero, double deposita) {
		this.numero = numero;
		this.saldo = deposita;
		this.titular.setNome(titular);
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular.getNome();
	}

	public void setTitular(String titular) {
		this.titular.setNome(titular);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void deposita(double valor) {
		this.setSaldo(this.getSaldo()+valor);
		JOptionPane.showMessageDialog(null,"Deu bom "+titular.getNome()+".\nSaldo atual de: "+getSaldo());
	}
	
	public void saque(double valor) {
		if(valor>this.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Valor solicitado para saque maior que saldo em conta");
		}else {
		this.setSaldo(this.getSaldo()-valor);
			JOptionPane.showMessageDialog(null, "Ultimo saque de: " + valor + "\nSaldo atual: " + this.getSaldo());
		}
	}
	
	public void transfere(Conta destino, double valor) {
		if(valor>this.getSaldo()) {
			JOptionPane.showMessageDialog(null, "Valor solicitado para transferência maior que saldo em conta");
		}else {
			this.setSaldo(getSaldo() - valor);
			destino.setSaldo(destino.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Transferência de: " + valor + "\nSaldo atual: " + this.getSaldo());
		}
	}
	
	@Override
	public String toString() {
		String conta = "Titular: "+titular.getNome()+"\nNúmero: "+getNumero()+"\nSaldo: "+getSaldo();
		return conta;
	}
}
