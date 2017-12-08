package br.com.caelum.financas.teste;

import br.com.caelum.financas.components.mapa.GoogleMaps;
import br.com.caelum.financas.components.mapa.MapLink;
import br.com.caelum.financas.components.mapa.Mapa;

/**
 * Created by mauyr on 24/02/17.
 */
public class TesteAdapterEBridge {

    public static void main(String[] args) {
        Mapa googleMaps = new GoogleMaps();
        System.out.println(googleMaps.retornaMapa());

        Mapa maplink = new MapLink();
        System.out.println(maplink.retornaMapa());
    }
}
