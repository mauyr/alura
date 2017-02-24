package br.com.caelum.financas.service.impostos;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 24/02/17.
 */
public class ICMS implements Imposto {
    @Override
    public double calculaImposto(double valor) {
        return valor * 0.10;
    }
}
