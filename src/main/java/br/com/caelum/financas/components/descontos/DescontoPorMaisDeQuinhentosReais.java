package br.com.caelum.financas.components.descontos;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 24/02/17.
 */
public class DescontoPorMaisDeQuinhentosReais implements Desconto {
    private Desconto proximo;

    public DescontoPorMaisDeQuinhentosReais(Desconto proximo) {
        this.proximo = proximo;
    }

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    @Override
    public double desconta(Orcamento orcamento) {
        if(orcamento.getValor() > 500) {
            return orcamento.getValor() * 0.07;
        }
        else {
            return proximo.desconta(orcamento);
        }
    }
}
