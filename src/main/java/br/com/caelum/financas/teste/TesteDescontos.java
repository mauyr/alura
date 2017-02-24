package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Item;
import br.com.caelum.financas.modelo.Orcamento;
import br.com.caelum.financas.util.CalculadorDeDescontos;

/**
 * Created by mauyr on 24/02/17.
 */
public class TesteDescontos {

    public static void main(String[] args) {

        Orcamento orcamento = new Orcamento(550.0);
        orcamento.addItem(new Item("CANETA", 300.0));
        orcamento.addItem(new Item("LAPIS", 250.0));

        double desconto = CalculadorDeDescontos.calcula(orcamento);

        System.out.println(desconto);
    }
}
