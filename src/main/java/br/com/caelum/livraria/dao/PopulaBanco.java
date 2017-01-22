package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.model.Venda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

public class PopulaBanco {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Autor assis = geraAutor("Machado de Assis");
		em.persist(assis);

		Autor amado = geraAutor("Jorge Amado");
		em.persist(amado);

		Autor coelho = geraAutor("Paulo Coelho");
		em.persist(coelho);

		Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro",
				"10/01/1899", 24.90, assis);
		Livro memorias = geraLivro("978-8-50-815415-9",
				"Memorias Postumas de Bras Cubas", "01/01/1881", 19.90, assis);
		Livro quincas = geraLivro("978-8-50-804084-1", "Quincas Borba",
				"01/01/1891", 16.90, assis);

		em.persist(casmurro);
		em.persist(memorias);
		em.persist(quincas);

		//vendas
		Venda vendaCasmurro2015 = geraVenda(2015, 130, casmurro);
		Venda vendaCasmurro2016 = geraVenda(2016, 80, casmurro);
		em.persist(vendaCasmurro2015);
		em.persist(vendaCasmurro2016);

		Venda vendaMemorias2015 = geraVenda(2015, 75, memorias);
		Venda vendaMemorias2016 = geraVenda(2016, 90, memorias);
		em.persist(vendaMemorias2015);
		em.persist(vendaMemorias2016);

		Venda vendaQuincas2015 = geraVenda(2015, 180, quincas);
		Venda vendaQuincas2016 = geraVenda(2016, 215, quincas);
		em.persist(vendaQuincas2015);
		em.persist(vendaQuincas2016);

		Livro alquemista = geraLivro("978-8-57-542758-3", "O Alquimista",
				"01/01/1988", 19.90, coelho);
		Livro brida = geraLivro("978-8-50-567258-7", "Brida", "01/01/1990",
				12.90, coelho);
		Livro valkirias = geraLivro("978-8-52-812458-8", "As Valkirias",
				"01/01/1992", 29.90, coelho);
		Livro maao = geraLivro("978-8-51-892238-9", "O Diario de um Mago",
				"01/01/1987", 9.90, coelho);

		em.persist(alquemista);
		em.persist(brida);
		em.persist(valkirias);
		em.persist(maao);

		//vendas
		Venda vendaAlquemista2015 = geraVenda(2015, 480, alquemista);
		Venda vendaAlquemista2016 = geraVenda(2016, 410, alquemista);
		em.persist(vendaAlquemista2015);
		em.persist(vendaAlquemista2016);

		Venda vendaBrida2015 = geraVenda(2015, 190, brida);
		Venda vendaBrida2016 = geraVenda(2016, 160, brida);
		em.persist(vendaBrida2015);
		em.persist(vendaBrida2016);

		Venda vendaValkirias2015 = geraVenda(2015, 350, valkirias);
		Venda vendaValkirias2016 = geraVenda(2016, 400, valkirias);
		em.persist(vendaValkirias2015);
		em.persist(vendaValkirias2016);

		Venda vendaMaao2015 = geraVenda(2015, 30, maao);
		Venda vendaMaao2016 = geraVenda(2016, 45, maao);
		em.persist(vendaMaao2015);
		em.persist(vendaMaao2016);

		Livro capitaes = geraLivro("978-8-50-831169-1", "Capitaes da Areia",
				"01/01/1937", 6.90, amado);
		Livro flor = geraLivro("978-8-53-592569-9",
				"Dona Flor e Seus Dois Maridos", "01/01/1966", 18.90, amado);

		em.persist(capitaes);
		em.persist(flor);

		//vendas
		Venda vendaCapitaes2015 = geraVenda(2015, 315, capitaes);
		Venda vendaCapitaes2016 = geraVenda(2016, 295, capitaes);
		em.persist(vendaCapitaes2015);
		em.persist(vendaCapitaes2016);

		Venda vendaFlor2015 = geraVenda(2015, 205, flor);
		Venda vendaFlor2016 = geraVenda(2016, 230, flor);
		em.persist(vendaFlor2015);
		em.persist(vendaFlor2016);

		em.getTransaction().commit();
		em.close();

	}

	private static Autor geraAutor(String nome) {
		Autor autor = new Autor();
		autor.setNome(nome);
		return autor;
	}

	private static Livro geraLivro(String isbn, String titulo, String data,
			double preco, Autor autor) {
		Livro livro = new Livro();
		livro.setIsbn(isbn);
		livro.setTitulo(titulo);
		livro.setDataLancamento(parseData(data));
		livro.setPreco(preco);
		livro.adicionaAutor(autor);
		return livro;
	}

	private static Venda geraVenda(Integer ano, Integer quantidade, Livro livro) {
		Venda venda = new Venda();
		venda.setAno(ano);;
		venda.setQuantidade(quantidade);
		venda.setLivro(livro);
		return venda;
	}

	@SuppressWarnings("unused")
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
