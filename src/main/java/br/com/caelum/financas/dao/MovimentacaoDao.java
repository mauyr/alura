package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

/**
 * Created by MauyrAlexandre on 10/12/2016.
 */
public class MovimentacaoDao {
    private EntityManager manager;

    public MovimentacaoDao(EntityManager manager) {
        this.manager = manager;
    }

    public Double mediaDaConta(Conta conta) {

        TypedQuery<Double> query =
                manager.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                        + " and m.tipoMovimentacao = 'SAIDA'", Double.class);
        query.setParameter("pConta", conta);
        return query.getSingleResult();
    }

    public Long totalMovimentacoes(Conta conta) {
        TypedQuery<Long> query = manager.createNamedQuery("totalDeMovimentacoes", Long.class);
        query.setParameter("pConta", conta);

        return query.getSingleResult();
    }

    public BigDecimal maiorValor(Conta conta) {

        TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);

        query.setParameter("pConta", conta);
        return query.getSingleResult();
    }
}
