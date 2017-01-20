package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mauyr on 20/01/17.
 */
public class LivroDao implements Serializable {

    @Inject
    EntityManager em;

    private DAO<Livro> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<>(em, Livro.class);
    }

    public Livro buscaPorId(Integer autorId) {
        return this.dao.buscaPorId(autorId);
    }

    public void adiciona(Livro livro) {
        this.dao.adiciona(livro);
    }

    public void atualiza(Livro livro) {
        this.dao.atualiza(livro);
    }

    public void remove(Livro livro) {
        this.dao.remove(livro);
    }

    public List<Livro> listaTodos() {
        return this.dao.listaTodos();
    }
}
