package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 24/02/17.
 */
public abstract class Imposto {

    private Imposto proximoImposto;

    public Imposto() {

    }

    public Imposto(Imposto proximoImposto) {
        this.proximoImposto = proximoImposto;
    }

    public double calculaImpostoEmCascata(double valor) {
        double valorImposto = this.calculaImposto(valor);

        if (proximoImposto!=null) {
            return proximoImposto.calculaImpostoEmCascata(valor) + valorImposto;
        } else {
            return valorImposto;
        }
    }

    public abstract double calculaImposto(double valor);
}
