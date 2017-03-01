package br.com.caelum.financas.teste;

import br.com.caelum.financas.components.impostos.ICPP;
import br.com.caelum.financas.components.impostos.IKCV;
import br.com.caelum.financas.components.impostos.Imposto;
import br.com.caelum.financas.modelo.Orcamento;
import br.com.caelum.financas.util.CalculadorDeImpostos;

/**
 * Created by mauyr on 01/03/17.
 */
public class TestaTemplateMethod {

    public static void main(String[] args) {
        Imposto icpp = new ICPP();
        Imposto ikcv = new IKCV();

        System.out.println("ICPP <= 500: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(400), icpp));
        System.out.println("ICPP > 500: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(800), icpp));

        System.out.println("IKCV <= 500: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(300), ikcv));
        System.out.println("IKCV > 500: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(700), ikcv));
    }
}
