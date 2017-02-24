package br.com.caelum.financas.components.investimentos;

/**
 * Created by mauyr on 24/02/17.
 */
public class Moderado implements Investimento {
    @Override
    public double calculaRendimento(double valorInvestido) {
        boolean menorRendimento = new java.util.Random().nextDouble() <= 0.50;
        return valorInvestido * (menorRendimento ? 0.025 : 0.007);
    }
}
