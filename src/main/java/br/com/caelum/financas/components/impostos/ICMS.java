package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 24/02/17.
 */
public class ICMS implements Imposto {
    @Override
    public double calculaImposto(double valor) {
        return valor * 0.10;
    }
}
