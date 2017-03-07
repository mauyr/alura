package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Orcamento;

/**
 * Created by mauyr on 07/03/17.
 */
public class TesteDescontoExtra {

    public static void main(String[] args) {
        Orcamento reforma = new Orcamento(500.0);

        reforma.aplicaDescontoExtra();
        System.out.println(reforma.getValor()); // imprime 475,00 pois descontou 5%
        reforma.aprova(); // aprova nota!

        reforma.aplicaDescontoExtra();
        System.out.println(reforma.getValor()); // imprime 465,50 pois descontou 2%

        reforma.finaliza();

        //lancaria excecao, pois não pode dar desconto nesse estado
//        reforma.aplicaDescontoExtra();
        //lança exceção, pois não pode ir para aprovado
//         reforma.aprova();
    }
}
