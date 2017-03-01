package br.com.caelum.financas.components.impostos;

/**
 * Created by mauyr on 01/03/17.
 */
public class IKCV extends TemplateImposto {
    @Override
    protected double menorTaxa(double valor) {
        return valor * 0.6;
    }

    @Override
    protected double maiorTaxa(double valor) {
        return valor * 0.1;
    }

    @Override
    protected boolean deveUsarMaiorTaxa(double valor) {
        if (valor > 500 && temItemComValorMaiorQueCem()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean temItemComValorMaiorQueCem() {
        //FIXME: Para validar sera preciso passar o orçamento para a classe imposto
        return true;
    }
}
