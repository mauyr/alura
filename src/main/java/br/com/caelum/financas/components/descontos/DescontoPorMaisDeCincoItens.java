package br.com.caelum.financas.components.descontos;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 24/02/17.
 */
public class DescontoPorMaisDeCincoItens implements Desconto {
    private Desconto proximo;

    public DescontoPorMaisDeCincoItens(Desconto proximo) {
        this.proximo = proximo;
    }

    public void setProximo(Desconto proximo) {
        this.proximo = proximo;
    }

    @Override
    public double desconta(Orcamento orcamento) {
        if(orcamento.getItens().size() > 5) {
            return orcamento.getValor() * 0.1;
        }
        else {
            return proximo.desconta(orcamento);
        }
    }
}
