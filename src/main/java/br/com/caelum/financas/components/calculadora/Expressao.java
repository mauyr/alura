package br.com.caelum.financas.components.calculadora;

import br.com.caelum.financas.components.impostos.Imposto;

/**
 * Created by mauyr on 24/03/17.
 */
public interface Expressao {

    int avalia();

    void aceita(Visitor visitor);
}
