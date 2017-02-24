package br.com.caelum.financas.components.descontos;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 24/02/17.
 */
public interface Desconto {
    double desconta(Orcamento orcamento);
    void setProximo(Desconto proximo);
}
