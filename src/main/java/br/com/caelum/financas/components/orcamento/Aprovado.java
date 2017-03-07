package br.com.caelum.financas.components.orcamento;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 07/03/17.
 */
public class Aprovado implements StatusOrcamento {
    @Override
    public void aplicaDescontoExtra(Orcamento orcamento) {
        orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.02));
    }

    @Override
    public void aprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento já está em estado de aprovação");
    }

    @Override
    public void reprova(Orcamento orcamento) {
        throw new RuntimeException("Orçamento está em estado de aprovação e não pode ser reprovado");
    }

    @Override
    public void finaliza(Orcamento orcamento) {
        orcamento.statusOrcamento = new Finalizado();
    }
}
