package br.com.caelum.financas.modelo;

/**
 * Created by mauyr on 07/03/17.
 */
public class ItemDaNota {

    private String descricao;
    private double valor;

    public ItemDaNota(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
