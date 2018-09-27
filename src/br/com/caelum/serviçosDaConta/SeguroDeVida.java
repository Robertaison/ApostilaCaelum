package br.com.caelum.serviçosDaConta;

public class SeguroDeVida implements Tributavel {
    private  double valor;
    private String titular;
    private int numeroApolice;

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroApolice() {
        return numeroApolice;
    }

    public void setNumeroApolice(int numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public Double getValorImposto() {
        return 42 + getValor()*0.02;
    }

    @Override
    public String getTitular() {
        return null;
    }

    @Override
    public String getTipo() {
        return null;
    }
}
