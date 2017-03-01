package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 01/03/17.
 */
public class ICPP extends TemplateImposto {
    @Override
    protected double menorTaxa(double valor) {
        return valor * 0.5;
    }

    @Override
    protected double maiorTaxa(double valor) {
        return valor * 0.7;
    }

    @Override
    protected boolean deveUsarMaiorTaxa(double valor) {
        if (valor > 500) {
            return true;
        } else {
            return false;
        }
    }
}
