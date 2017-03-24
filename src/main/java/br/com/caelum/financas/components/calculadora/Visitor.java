package br.com.caelum.financas.components.calculadora;

/**
 * Created by mauyr on 24/03/17.
 */
public interface Visitor {

    void visitaSoma(Soma soma);

    void visitaSubtracao(Subtracao subtracao);

    void visitaMultiplicacao(Multiplicacao multiplicacao);

    void visitaDivisao(Divisao divisao);

    void visitaNumero(Numero numero);
}
