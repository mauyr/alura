package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 24/02/17.
 */
public class IR extends Imposto {

    public IR() {

    }

    public IR(Imposto proximoImposto) {
        super(proximoImposto);
    }

    @Override
    public double calculaImposto(double valor) {
        return valor*0.25;
    }
}
