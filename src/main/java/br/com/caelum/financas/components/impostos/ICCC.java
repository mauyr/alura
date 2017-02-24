package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 24/02/17.
 */
public class ICCC implements Imposto {


    @Override
    public double calculaImposto(double valor) {
        double imposto = 0;
        if (valor<1000) {
            imposto = valor*0.05;
        } else if (valor>=1000 && valor<=3000) {
            imposto = valor*0.07;
        } else {
            imposto = valor*0.08 + 30;
        }
        return imposto;
    }
}
