package br.com.caelum.financas.components.investimentos;

/**
 * Created by mauyr on 24/02/17.
 */
public class Conservador implements Investimento {
    @Override
    public double calculaRendimento(double valorInvestido) {
        return valorInvestido*0.008;
    }
}
