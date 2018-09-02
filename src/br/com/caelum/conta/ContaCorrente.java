package br.com.caelum.conta;

public class ContaCorrente extends Conta {
    private int totalContaCorrente = 0;

    public ContaCorrente(){
        super();
        setTotalContaCorrente(getTotalContaCorrente()+1);
    }

    public ContaCorrente(String nome, int numero, int dia, int mes, int ano){
        super(nome, numero, dia, mes, ano);
        setTotalContaCorrente(getTotalContaCorrente()+1);
    }

    public void setTotalContaCorrente(int totalContaCorrente) {
        this.totalContaCorrente = totalContaCorrente;
    }

    public int getTotalContaCorrente() {
        return totalContaCorrente;
    }
}
