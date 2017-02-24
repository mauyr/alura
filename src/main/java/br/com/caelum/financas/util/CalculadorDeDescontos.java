package br.com.caelum.financas.util;

import br.com.caelum.financas.components.descontos.Desconto;
import br.com.caelum.financas.components.descontos.DescontoPorMaisDeCincoItens;
import br.com.caelum.financas.components.descontos.DescontoPorMaisDeQuinhentosReais;
import br.com.caelum.financas.components.descontos.SemDesconto;
import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 24/02/17.
 */
public class CalculadorDeDescontos {

    public static double calcula(Orcamento orcamento) {
        Desconto d3 = new SemDesconto();
        Desconto d2 = new DescontoPorMaisDeCincoItens(d3);
        Desconto d1 = new DescontoPorMaisDeQuinhentosReais(d2);

        return d1.desconta(orcamento);
    }
}
