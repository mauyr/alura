package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public class Numero implements Expressao {

    private int numero;

    public Numero(int numero) {

	this.setNumero(numero);
    }

    @Override
    public int avalia() {
	return this.getNumero();
    }

    @Override public void aceita(Visitor visitor) {
        visitor.visitaNumero(this);
    }

    public int getNumero() {
	return numero;
    }

    public void setNumero(int numero) {
	this.numero = numero;
    }
}
