package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.List;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();

	private Integer autorId;

	public List<Autor> getAutores() {
		return new DAO<>(Autor.class).listaTodos();
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public Livro getLivro() {
		return livro;
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor",  new FacesMessage("Livro deve ter pelo menos um Autor"));
			return;
		}

		new DAO<>(Livro.class).adiciona(this.livro);
		this.livro = new Livro();
	}

	public void gravarAutor() {
		Autor autor = new DAO<>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}

	public List<Livro> getLivros() {
		return new DAO<>(Livro.class).listaTodos();
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}
	}
}
