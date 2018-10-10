package br.com.caelum.conta;


import br.com.caelum.serviçosDaConta.ContaTributavel;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ContaPoupanca implements ContaTributavel {
    private double saldo;
    private String titular;
    private String tipo;

    public ContaPoupanca(String nome){
        setTitular(nome);
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public void Menu() {
        int op4 =5;
        while(op4!=0){
            op4 = Integer.parseInt(JOptionPane.showInputDialog(toString()));
            if (op4 == 1) {
                int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite quanto quer sacar."));
                saca(valor);
            } else if (op4 == 2) {
                int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite quanto quer depositar."));
                deposita(valor);
            }else if(op4==0){
                JOptionPane.showMessageDialog(null, "Retornando ao menu anterior.");
            }
        }
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void deposita(double valor) {
        setSaldo(getSaldo()+valor);
    }

    @Override
    public void saca(double valor) {
        if(valor<=0){
            JOptionPane.showMessageDialog(null,"Digite um valor maior que R$0,00.");
        }
        setSaldo(getSaldo()+valor);
    }

    @Override
    public Double getValorImposto() {
        return getSaldo()*0.09;
    }

    @Override
    public String getTitular() {
        return this.titular;
    }

    @Override
    public String getTipo() {
        return "Conta poupança.";
    }

    @Override
    public String data() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter
                                        .ofLocalizedDateTime(FormatStyle.SHORT)
                                        .withLocale(new Locale("pt", "br"));
        return agora.format(formatador);
    }

    @Override
    public String toString() {
        String conta = "Nome: " + getTitular() + "\n" +
                       "Tipo: " + getTipo() + "\n" +
                       "Saldo: " +  getSaldo() + "\n" +
                       "Redimento último mês: " + getValorImposto() + "\n\n\n" +
                        "1. Sacar" + "\n" +
                        "2. Depositar" + "\n\n" +
                        "0. Retornar ao menu anterior" + "\n\n\n" +
                       "Data atual: " + data();
        return conta;
    }


}
