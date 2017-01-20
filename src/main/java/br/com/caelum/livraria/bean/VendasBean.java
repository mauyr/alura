package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.model.Venda;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mauyr on 19/01/17.
 */
@Named
@ViewScoped
public class VendasBean implements Serializable {

    public BarChartModel getVendasModel() {

        BarChartModel model = new BarChartModel();
        model.setAnimate(true);

        ChartSeries vendaSerie = new ChartSeries();
        vendaSerie.setLabel("Vendas 2016");

        List<Venda> vendas = getVendas(9999);

        for (Venda venda : vendas) {
            vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
        }

        model.addSeries(vendaSerie);

        ChartSeries vendaSerie2015 = new ChartSeries();
        vendaSerie2015.setLabel("Vendas 2015");

        vendas = getVendas(7777);

        for (Venda venda : vendas) {
            vendaSerie2015.set(venda.getLivro().getTitulo(),
                    venda.getQuantidade());
        }

        model.addSeries(vendaSerie2015);

        return model;
    }

    public List<Venda> getVendas(long seed) {

        List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
        List<Venda> vendas = new ArrayList<Venda>();

        Random random = new Random(seed);

        for (Livro livro : livros) {
            Integer quantidade = random.nextInt(1000);
            vendas.add(new Venda(livro, quantidade));
        }

        return vendas;
    }
}
