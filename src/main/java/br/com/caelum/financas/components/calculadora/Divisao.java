package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public class Divisao
		implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Divisao(Expressao esquerda, Expressao direita) {
	this.esquerda = esquerda;
	this.direita = direita;
    }

    @Override public int avalia() {
        int expressaoEsquerda = esquerda.avalia();
        int expressaoDireita = direita.avalia();
	return expressaoEsquerda / expressaoDireita;
    }
}
