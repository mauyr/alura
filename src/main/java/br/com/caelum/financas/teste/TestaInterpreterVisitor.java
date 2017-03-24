package br.com.caelum.financas.teste;

import br.com.caelum.financas.components.calculadora.*;
import org.hibernate.hql.internal.ast.util.NodeTraverser;

/**
 * Created by mauyr on 24/03/17.
 */
public class TestaInterpreterVisitor {

    public static void main(String[] args) {
        Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
        Expressao direita = new Soma(new Numero(2), new Numero(10));

        Expressao resultado1 = new Soma(esquerda, direita);

        Expressao resultado2 = new Multiplicacao(resultado1, new Numero(2));

        Expressao conta = new Divisao(resultado2, new Numero(3));

        System.out.println(conta.avalia());

        Visitor impressora = new Impressora();
        conta.aceita(impressora);

        System.out.println(" \n --- ");

        Visitor impressoraTipo2 = new ImpressoraTipo2();
        conta.aceita(impressoraTipo2);
    }
}
