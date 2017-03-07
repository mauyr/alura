package br.com.caelum.financas.components.notafiscal;

import br.com.caelum.financas.modelo.ItemDaNota;
import br.com.caelum.financas.modelo.NotaFiscal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by mauyr on 07/03/17.
 */
public class NotaFiscalBuilder {

    private String empresa;
    private String cnpj;
    private Calendar dataEmissao;
    private String observacoes;
    private List<ItemDaNota> itens = new ArrayList<>();

    public NotaFiscalBuilder paraEmpresa(String empresa) {
        this.empresa = empresa;
        return this;
    }

    public NotaFiscalBuilder comCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public NotaFiscalBuilder naDataAtual() {
        this.dataEmissao = Calendar.getInstance();
        return this;
    }

    public NotaFiscalBuilder comObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    public NotaFiscalBuilder comItem(ItemDaNota itemDaNota) {
        this.itens.add(itemDaNota);
        return this;
    }

    public NotaFiscal build() {
        return new NotaFiscal(this.empresa, this.cnpj, this.dataEmissao, this.observacoes, this.itens);
    }
}
