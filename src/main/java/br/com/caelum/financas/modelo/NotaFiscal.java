package br.com.caelum.financas.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mauyr on 07/03/17.
 */
public class NotaFiscal {

    private String razaoSocial;
    private String cnpj;
    private Calendar dataEmissao;
    private String observacoes;

    private List<ItemDaNota> itens = new ArrayList<>();

    public NotaFiscal(String razaoSocial, String cnpj, Calendar dataEmissao, String observacoes, List<ItemDaNota> itens) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataEmissao = dataEmissao;
        this.observacoes = observacoes;
        this.itens = itens;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<ItemDaNota> getItens() {
        return itens;
    }

    public void setItens(List<ItemDaNota> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        double valorTotal = 0.0;
        for (ItemDaNota item : this.itens) {
            valorTotal += item.getValor();
        }
        return valorTotal;
    }
}
