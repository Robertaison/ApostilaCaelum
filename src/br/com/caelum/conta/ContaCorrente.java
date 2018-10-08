package br.com.caelum.conta;

import br.com.caelum.serviçosDaConta.Tributavel;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ContaCorrente implements ContaTributavel{
    private double saldo;
    private String titular;
    private String tipo;
    private int numeroConta=00;
    private int agencia=500;

    public ContaCorrente(String nome, int numero){
        setTitular(nome);
        setNumeroConta(numero);
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta += numeroConta;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public void deposita(double valor) {
        if(valor<=0){
            JOptionPane.showMessageDialog(null,"Digite um valor maior que R$0,00.");
        }
        setSaldo(getSaldo()+valor);
    }

    @Override
    public void saca(double valor) {
        if(valor>getSaldo()){
            JOptionPane.showMessageDialog(null,"O senhor não  possuí saldo suficiente");
        }else{
            setSaldo(getSaldo()-valor);
        }
    }

    @Override
    public void atualiza(double taxaSelic) {
        setSaldo(getSaldo()*taxaSelic);
    }

    @Override
    public Double getValorImposto() {
        return getSaldo()*0.15;
    }

    @Override
    public String getTitular() {
        return "Conta Corrente.";
    }

    @Override
    public String getTipo() {
        return getTitular();
    }

    @Override
    public String data() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("pt", "br"));
        return agora.format(formatador);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    @Override
    public String toString() {
        String conta = "Nome: " + getTitular() + "\n" +
                "Conta: " + getAgencia() + "-" + getNumeroConta() + "\n" +
                "Tipo: " + getTipo() + "\n\n" +
                "Saldo: R$" +  getSaldo() + "\n" +
                "Imposto devedor: R$" + getValorImposto() + "\n\n" +
                "Digite: " + "\n" +
                "1. Sacar" + "\n" +
                "2. Depositar" + "\n\n" +
                "0. Retornar ao menu anterior" + "\n\n\n" +
                "Data atual: " + data();
        return conta;
    }
}
