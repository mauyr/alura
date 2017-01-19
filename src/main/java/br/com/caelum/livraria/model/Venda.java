package br.com.caelum.livraria.model;

/**
 * Created by mauyr on 19/01/17.
 */
public class Venda {


    private Livro livro;
    private Integer quantidade;

    public Venda(Livro livro, Integer quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
