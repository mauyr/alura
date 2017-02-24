package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Orcamento;
import br.com.caelum.financas.components.impostos.ICCC;
import br.com.caelum.financas.components.impostos.ICMS;
import br.com.caelum.financas.components.impostos.ISS;
import br.com.caelum.financas.components.impostos.Imposto;
import br.com.caelum.financas.components.investimentos.Arrojado;
import br.com.caelum.financas.components.investimentos.Conservador;
import br.com.caelum.financas.components.investimentos.Moderado;
import br.com.caelum.financas.util.CalculadorDeImpostos;
import br.com.caelum.financas.util.RealizadorDeInvestimentos;

/**
 * Created by mauyr on 24/02/17.
 */
public class TesteStrategyImpostosEInvestimento {

    public static void main(String[] args) {
        Imposto iss = new ISS();
        Imposto icms = new ICMS();
        Imposto iccc = new ICCC();

        Orcamento orcamento = new Orcamento(1000.50);

        System.out.println("ISS: " + CalculadorDeImpostos.realizaCalculo(orcamento, iss));
        System.out.println("ICMS: " + CalculadorDeImpostos.realizaCalculo(orcamento, icms));
        System.out.println("--------------------------------------------------------");
        System.out.println("ICCC < 1000: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(900), iccc));
        System.out.println("ICCC >=1000 <=3000: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(2000), iccc));
        System.out.println("ICCC >3000: " + CalculadorDeImpostos.realizaCalculo(new Orcamento(4000), iccc));


        RealizadorDeInvestimentos.calculaInvestimento(4000.00, new Conservador());
        RealizadorDeInvestimentos.calculaInvestimento(4000.00, new Moderado());
        RealizadorDeInvestimentos.calculaInvestimento(4000.00, new Arrojado());
    }
}
