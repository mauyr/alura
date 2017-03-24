package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public class Subtracao
		implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Subtracao(Expressao esquerda, Expressao direita) {
	this.setEsquerda(esquerda);
	this.setDireita(direita);
    }

    @Override public int avalia() {
        int expressaoEsquerda = this.getEsquerda().avalia();
        int expressaoDireita = this.getDireita().avalia();
	return expressaoEsquerda - expressaoDireita;
    }

    @Override public void aceita(Visitor visitor) {
        visitor.visitaSubtracao(this);
    }

    public Expressao getEsquerda() {
	return esquerda;
    }

    public void setEsquerda(Expressao esquerda) {
	this.esquerda = esquerda;
    }

    public Expressao getDireita() {
	return direita;
    }

    public void setDireita(Expressao direita) {
	this.direita = direita;
    }
}
