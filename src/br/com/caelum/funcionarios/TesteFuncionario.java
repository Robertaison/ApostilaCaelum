package br.com.caelum.funcionarios;

public class TesteFuncionario {
	public static void main (String[] args) {
		Gerente g1 = new Gerente();
		g1.setSenha(2222);
		g1.login(2222);
	}
}
