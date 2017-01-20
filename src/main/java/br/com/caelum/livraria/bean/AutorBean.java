package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.util.RedirectView;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AutorBean implements Serializable {

    @Inject
    private AutorDao dao;

    private Autor autor = new Autor();

    private Integer autorId = 0;

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void carregarAutorPelaId() {
        this.autor =this.dao.buscaPorId(autorId);
    }

    public Autor getAutor() {
        return autor;
    }

    public RedirectView gravar() {
        System.out.println("Gravando autor " + this.autor.getNome());

        if (this.autor.getId() == null) {
           this.dao.adiciona(this.autor);
        } else {
           this.dao.atualiza(this.autor);
        }

        return new RedirectView("livro");
    }

    public void carregar(Autor autor) {
        System.out.println("Carregando autor" + autor.getNome());
        this.autor = autor;
    }

    public void remover(Autor autor) {
        System.out.println("Removendo autor" + autor.getNome());
       this.dao.remove(autor);
    }

    public List<Autor> getAutores() {
        return this.dao.listaTodos();
    }
}
