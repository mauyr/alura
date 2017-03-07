package br.com.caelum.financas.components.orcamento;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 07/03/17.
 */
public class Finalizado implements StatusOrcamento {
    @Override
    public void aplicaDescontoExtra(Orcamento orcamento) {
        throw new RuntimeException("Orçamentos finalizados não recebem desconto extra!");
    }

    @Override
    public void aprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já está finalizado");
    }

    @Override
    public void reprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já está finalizado");
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já está finalizado");
    }
}
