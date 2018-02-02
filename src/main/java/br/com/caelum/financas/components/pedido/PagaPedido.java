package br.com.caelum.financas.components.pedido;

import br.com.caelum.financas.components.fila.Comando;
import br.com.caelum.financas.modelo.Pedido;

public class PagaPedido implements Comando {

    private Pedido pedido;

    public PagaPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executa() {
        System.out.println("Pagando pedido " + this.pedido.getCliente());
        this.pedido.paga();
    }
}
