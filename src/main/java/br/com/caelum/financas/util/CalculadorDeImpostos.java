package br.com.caelum.financas.util;

import br.com.caelum.financas.modelo.Orcamento;
import br.com.caelum.financas.components.impostos.Imposto;

/**
 * Created by mauyr on 24/02/17.
 */
public class CalculadorDeImpostos {

    public static double realizaCalculo(Orcamento orcamento, Imposto imposto) {
        return realizaCalculo(orcamento.getValor(), imposto);
    }

    public static double realizaCalculo(double valor, Imposto imposto) {
        return imposto.calculaImposto(valor);
    }
}
