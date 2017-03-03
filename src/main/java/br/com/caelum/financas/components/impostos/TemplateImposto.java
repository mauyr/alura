package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 01/03/17.
 */
public abstract class TemplateImposto extends Imposto {

    public TemplateImposto(){

    }

    public TemplateImposto(Imposto proximoImposto) {
        super(proximoImposto);
    }

    @Override
    public final double calculaImposto(double valor) {
        if (deveUsarMaiorTaxa(valor)) {
            return maiorTaxa(valor);
        } else {
            return menorTaxa(valor);
        }
    }

    protected abstract double menorTaxa(double valor);

    protected abstract double maiorTaxa(double valor);

    protected abstract boolean deveUsarMaiorTaxa(double valor);


}
