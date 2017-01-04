package br.com.caelum.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by MauyrAlexandre on 10/12/2016.
 */
public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Query query = manager.createQuery("select distinct c from Conta c join fetch c.movimentacoes");

        List<Conta> results = query.getResultList();
        for (Conta result : results) {
            System.out.println("Conta: " + result.getTitular() + " - Movimentações: " + result.getMovimentacoes().size());
        }

        manager.close();
    }
}
