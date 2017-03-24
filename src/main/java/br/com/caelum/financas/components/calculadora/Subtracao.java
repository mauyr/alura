package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public class Subtracao
		implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Subtracao(Expressao esquerda, Expressao direita) {
	this.esquerda = esquerda;
	this.direita = direita;
    }

    @Override public int avalia() {
        int expressaoEsquerda = this.esquerda.avalia();
        int expressaoDireita = this.direita.avalia();
	return expressaoEsquerda - expressaoDireita;
    }
}
