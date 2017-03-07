package br.com.caelum.financas.components.orcamento;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 07/03/17.
 */
public interface StatusOrcamento {
    void aplicaDescontoExtra(Orcamento orcamento);
    void aprova(Orcamento orcamento);
    void reprova(Orcamento orcamento);
    void finaliza(Orcamento orcamento);
}
