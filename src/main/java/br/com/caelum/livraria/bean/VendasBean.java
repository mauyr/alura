package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.dao.VendaDao;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.model.Venda;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

    @Inject
    VendaDao vendaDao;

    public BarChartModel getVendasModel() {

        BarChartModel model = new BarChartModel();
        model.setAnimate(true);

        ChartSeries vendaSerie = new ChartSeries();
        vendaSerie.setLabel("Vendas 2016");

        List<Venda> vendas = vendaDao.getVendas(2015);

        for (Venda venda : vendas) {
            vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
        }

        model.addSeries(vendaSerie);

        ChartSeries vendaSerie2015 = new ChartSeries();
        vendaSerie2015.setLabel("Vendas 2015");

        vendas = vendaDao.getVendas(2016);

        for (Venda venda : vendas) {
            vendaSerie2015.set(venda.getLivro().getTitulo(),
                    venda.getQuantidade());
        }

        model.addSeries(vendaSerie2015);

        return model;
    }

}
