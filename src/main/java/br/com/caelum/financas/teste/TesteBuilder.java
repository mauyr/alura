package br.com.caelum.financas.teste;

import br.com.caelum.financas.components.notafiscal.NotaFiscalBuilder;
import br.com.caelum.financas.modelo.ItemDaNota;
import br.com.caelum.financas.modelo.NotaFiscal;

/**
 * Created by mauyr on 07/03/17.
 */
public class TesteBuilder {

    public static void main(String[] args) {
        NotaFiscalBuilder builder = new NotaFiscalBuilder();
        NotaFiscal nf = builder.paraEmpresa("Empresa teste")
                .comCNPJ("13.999.999/0001-99")
                .comObservacoes("Observacoes")
                .comItem(new ItemDaNota("Item 1", 150.0))
                .comItem(new ItemDaNota("Item 2", 200.0))
                .naDataAtual()
                .build();

        System.out.println(nf.getValorTotal());
    }
}
