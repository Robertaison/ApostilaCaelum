package br.com.caelum.serviçosDaConta;

public class ManipuladorDeContas {

    private SeguroDeVida seguroDeVida;

    public void criaSeguro(SeguroDeVida evento){
        this.seguroDeVida = new SeguroDeVida();
        this.seguroDeVida.setNumeroApolice(evento.getNumeroApolice());
        this.seguroDeVida.setTitular(evento.getTitular());
        this.seguroDeVida.setValor(evento.getValor());
    }
}
