package br.com.caelum.conta;

import br.com.caelum.serviçosDaConta.Tributavel;

public class ContaCorrente extends Conta implements Tributavel {
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

    @Override
    public Double getValorImposto() {
        return getSaldo()*0.01;
    }

    @Override
    public String getTipo() {
        return null;
    }

    @Override
    public String getTitular(){
        return "";
    }
}
