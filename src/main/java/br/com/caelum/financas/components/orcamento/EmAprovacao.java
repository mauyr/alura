package br.com.caelum.financas.components.orcamento;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 07/03/17.
 */
public class EmAprovacao implements StatusOrcamento {
    @Override
    public void aplicaDescontoExtra(Orcamento orcamento) {
        orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.05));
    }

    @Override
    public void aprova(Orcamento orcamento) {
        orcamento.statusOrcamento = new Aprovado();
    }

    @Override
    public void reprova(Orcamento orcamento) {
        orcamento.statusOrcamento = new Reprovado();
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        throw new RuntimeException("Orcamento em aprovação não podem ir para finalizado diretamente");
    }
}
