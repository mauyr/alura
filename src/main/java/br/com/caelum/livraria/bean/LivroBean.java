package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@Named
@ViewScoped
public class LivroBean implements Serializable {

	@Inject
	private LivroDao livroDao;

	@Inject
	private AutorDao autorDao;
	
	private Livro livro = new Livro();

	private Integer livroId;

	private Integer autorId;

	private List<Livro> livros;

	public List<Autor> getAutores() {
		return this.autorDao.listaTodos();
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void carregar(Livro livro) {
		System.out.println("Carregando autor" + livro.getTitulo());
		this.livro = livroDao.buscaPorId(livro.getId());
	}

	public void carregarLivroPelaId() {
		this.livro = this.livroDao.buscaPorId(livroId);
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor",  new FacesMessage("Livro deve ter pelo menos um Autor"));
			return;
		}

		if(this.livro.getId() == null) {
			this.livroDao.adiciona(this.livro);
		} else {
			this.livroDao.atualiza(this.livro);
		}
		this.livros = this.livroDao.listaTodos();

		this.livro = new Livro();
	}

	public void gravarAutor() {
		Autor autor = this.autorDao.buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}

	public void remover(Livro livro) {
		System.out.println("Removendo livro " + livro.getTitulo());
		this.livroDao.remove(livro);

		this.livros = this.livroDao.listaTodos();
	}

	public void removerAutorDoLivro(Autor autor) {
		System.out.println("Removendo auto do livro " + autor.getNome());
		this.livro.removeAutor(autor);
	}

	public List<Livro> getLivros() {
		if(this.livros == null) {
			this.livros = this.livroDao.listaTodos();
		}

		return livros;
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

	public boolean precoEhMenor(Object valorColuna, Object filtroDigitado, Locale locale) { // java.util.Locale

		//tirando espaços do filtro
		String textoDigitado = (filtroDigitado == null) ? null : filtroDigitado.toString().trim();

		System.out.println("Filtrando pelo " + textoDigitado + ", Valor do elemento: " + valorColuna);

		// o filtro é nulo ou vazio?
		if (textoDigitado == null || textoDigitado.equals("")) {
			return true;
		}

		// elemento da tabela é nulo?
		if (valorColuna == null) {
			return false;
		}

		try {
			// fazendo o parsing do filtro para converter para Double
			Double precoDigitado = Double.valueOf(textoDigitado);
			Double precoColuna = (Double) valorColuna;

			// comparando os valores, compareTo devolve um valor negativo se o value é menor do que o filtro
			return precoColuna.compareTo(precoDigitado) < 0;

		} catch (NumberFormatException e) {

			// usuario nao digitou um numero
			return false;
		}
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}
}
