package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public class Multiplicacao
		implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Multiplicacao(Expressao esquerda, Expressao direita) {
	this.esquerda = esquerda;
	this.direita = direita;
    }

    @Override public int avalia() {
        int expressaoEsquerda = esquerda.avalia();
        int expressaoDireira = direita.avalia();

	return expressaoEsquerda * expressaoDireira;
    }
}
