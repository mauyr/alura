package br.com.caelum.financas.components.descontos;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 24/02/17.
 */
public class SemDesconto implements Desconto {
    @Override
    public double desconta(Orcamento orcamento) {
        return 0;
    }

    @Override
    public void setProximo(Desconto proximo) {

    }
}
