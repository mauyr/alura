package br.com.caelum.financas.modelo;

import br.com.caelum.financas.components.orcamento.EmAprovacao;
import br.com.caelum.financas.components.orcamento.StatusOrcamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauyr on 24/02/17.
 */
public class Orcamento {
    private double valor;
    private List<Item> itens = new ArrayList<>();

    public StatusOrcamento statusOrcamento;

    public Orcamento() {
        this.statusOrcamento = new EmAprovacao();
    }
    public Orcamento(double valor) {
        this.valor = valor;
        this.statusOrcamento = new EmAprovacao();
    }
    public Orcamento(double valor, StatusOrcamento statusOrcamento) {
        this.valor = valor;
        this.statusOrcamento = statusOrcamento;
    }

    public void aplicaDescontoExtra() {
        statusOrcamento.aplicaDescontoExtra(this);
    }

    public void aprova() {
        statusOrcamento.aprova(this);
    }

    public void reprova() {
        statusOrcamento.reprova(this);
    }

    public void finaliza() {
        statusOrcamento.finaliza(this);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }
}
