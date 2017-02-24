package br.com.caelum.financas.service.investimentos;

/**
 * Created by mauyr on 24/02/17.
 */
public class Arrojado implements Investimento {
    @Override
    public double calculaRendimento(double valorInvestido) {
        double chances = new java.util.Random().nextDouble();
        if (chances <= 0.2) {
            return valorInvestido*0.05;
        } else if (chances > 0.2 && chances <= 0.5) {
            return valorInvestido*0.03;
        } else {
            return valorInvestido*0.006;
        }
    }
}
