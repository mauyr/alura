package br.com.caelum.financas.teste;

import br.com.caelum.financas.components.calculadora.Expressao;
import br.com.caelum.financas.components.calculadora.Numero;
import br.com.caelum.financas.components.calculadora.Soma;
import br.com.caelum.financas.components.calculadora.Subtracao;

/**
 * Created by mauyr on 24/03/17.
 */
public class TestaInterpreter {

    public static void main(String[] args) {
        Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
        Expressao direita = new Soma(new Numero(2), new Numero(10));

        Expressao conta = new Soma(esquerda, direita);

        System.out.println(conta.avalia());
    }
}
