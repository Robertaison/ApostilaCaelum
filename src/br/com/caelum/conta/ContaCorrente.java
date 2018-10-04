package br.com.caelum.conta;

import br.com.caelum.serviçosDaConta.Tributavel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ContaCorrente implements ContaTributavel{
    private double saldo;
    private String titular;
    private String tipo;

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void deposita(double valor) {
        setSaldo(valor);
    }

    @Override
    public void saca(double valor) {

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

    @Override
    public String toString() {
        String conta = "Nome: " + getTitular() + "\n" +
                "Tipo: " + getTipo() + "\n" +
                "Saldo: " +  getSaldo() + "\n" +
                "Imposto devedor: " + getValorImposto() + "\n\n\n" +
                "Data atual: " + data();
        return conta;
    }
}
