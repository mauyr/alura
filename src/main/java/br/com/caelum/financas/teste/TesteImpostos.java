package br.com.caelum.financas.teste;

import br.com.caelum.financas.components.impostos.ICCC;
import br.com.caelum.financas.components.impostos.IR;

/**
 * Created by mauyr on 03/03/17.
 */
public class TesteImpostos {

    public static void main(String[] args) {
        ICCC iccc = new ICCC();
        IR ir = new IR(iccc);

        System.out.println(ir.calculaImpostoEmCascata(1000.00));
    }

}
