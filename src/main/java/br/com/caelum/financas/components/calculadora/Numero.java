package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public class Numero implements Expressao {

    private int numero;

    public Numero(int numero) {

	this.numero = numero;
    }

    @Override
    public int avalia() {
	return this.numero;
    }
}
