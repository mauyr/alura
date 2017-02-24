package br.com.caelum.financas.util;

import br.com.caelum.financas.components.impostos.IR;
import br.com.caelum.financas.components.investimentos.Investimento;

/**
 * Created by mauyr on 24/02/17.
 */
public class RealizadorDeInvestimentos {

    public static double calculaInvestimento(double valor, Investimento investimento) {
        double rendimento = investimento.calculaRendimento(valor);
        double imposto = CalculadorDeImpostos.realizaCalculo(rendimento, new IR());

        System.out.println("Rendimento bruto: " + rendimento);
        System.out.println("Imposto: " + imposto);
        System.out.println("Despositado na conta: " + (rendimento-imposto));
        return rendimento-imposto;
    }
}
