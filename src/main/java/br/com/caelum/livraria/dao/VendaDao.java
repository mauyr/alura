package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.model.Venda;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MauyrAlexandre on 22/01/2017.
 */
public class VendaDao implements Serializable {

    @Inject
    EntityManager em;

    public List<Venda> getVendas(Integer ano) {
        TypedQuery<Venda> query = em.createQuery("select v from Venda v where v.ano = :pAno", Venda.class);
        query.setParameter("pAno", ano);

        List<Venda> vendas = query.getResultList();
        return vendas;
    }
}
