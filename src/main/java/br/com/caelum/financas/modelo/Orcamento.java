package br.com.caelum.financas.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mauyr on 24/02/17.
 */
public class Orcamento {
    private double valor;
    private List<Item> itens = new ArrayList<>();

    public Orcamento(double valor) {
        this.valor = valor;
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
