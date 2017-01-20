package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.log.LogTime;
import br.com.caelum.livraria.model.Autor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mauyr on 20/01/17.
 */
public class AutorDao implements Serializable {

    @Inject
    EntityManager em;

    private DAO<Autor> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<>(em, Autor.class);
    }

    public Autor buscaPorId(Integer autorId) {
        return this.dao.buscaPorId(autorId);
    }

    public void adiciona(Autor autor) {
        this.dao.adiciona(autor);
    }

    public void atualiza(Autor autor) {
        this.dao.atualiza(autor);
    }

    public void remove(Autor autor) {
        this.dao.remove(autor);
    }

    @LogTime
    public List<Autor> listaTodos() {
        return this.dao.listaTodos();
    }
}
