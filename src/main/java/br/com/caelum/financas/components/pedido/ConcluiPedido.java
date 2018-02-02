package br.com.caelum.financas.components.pedido;

import br.com.caelum.financas.components.fila.Comando;
import br.com.caelum.financas.modelo.Pedido;

public class ConcluiPedido implements Comando {

    private Pedido pedido;

    public ConcluiPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executa() {
        System.out.println("Finalizando pedido " + this.pedido.getCliente());
        this.pedido.finaliza();
    }
}
