package br.com.caelum.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPA {

    public static void main(String[] args) {
        double inicio = System.currentTimeMillis();

        populaBanco();

        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
    }

    private static void populaBanco() {
        Conta conta1 = insereConta("Maria dos Santos", "001 - BANCO DO BRASIL", "6543", "16987-8");
        insereMovimentacao(conta1, Calendar.getInstance(), "Conta de luz - ABRIL/2012", TipoMovimentacao.SAIDA, new BigDecimal("135"));
        insereMovimentacao(conta1, Calendar.getInstance(), "Almoco no Restaurante - AGOSTO/2012", TipoMovimentacao.SAIDA, new BigDecimal("175.8"));
        insereMovimentacao(conta1, Calendar.getInstance(), "Aluguel - MAIO/2012", TipoMovimentacao.ENTRADA, new BigDecimal("680"));
        insereMovimentacao(conta1, Calendar.getInstance(), "Salario - FEVEREIRO/2012", TipoMovimentacao.ENTRADA, new BigDecimal("3830.68"));

        Conta conta2 = insereConta("Paulo Roberto Souza", "237 - BANCO BRADESCO", "1745", "86759-1");
        insereMovimentacao(conta2, Calendar.getInstance(), "Conta de telefone - SETEMBRO/2011", TipoMovimentacao.SAIDA, new BigDecimal("168.27"));
        insereMovimentacao(conta2, Calendar.getInstance(), "Aniversario - MAIO/2011", TipoMovimentacao.ENTRADA, new BigDecimal("200"));

        Conta conta3 = insereConta("Antonio Duraes", "341 - BANCO ITAU UNIBANCO", "4606", "46346-3");
        insereMovimentacao(conta3, Calendar.getInstance(), "Lanche - JULHO/2011 ", TipoMovimentacao.SAIDA, new BigDecimal("28.5"));
        insereMovimentacao(conta3, Calendar.getInstance(), "Presente - DEZEMBRO/2011", TipoMovimentacao.SAIDA, new BigDecimal("49.99"));
        insereMovimentacao(conta3, Calendar.getInstance(), "Bonus - JANEIRO/2012", TipoMovimentacao.ENTRADA, new BigDecimal("2000"));

        Conta conta4 = insereConta("Lendra Marques", "033 - BANCO SANTANDER", "9876", "12345-6");
        insereMovimentacao(conta4, Calendar.getInstance(), "Carnaval - MARCO/2012", TipoMovimentacao.SAIDA, new BigDecimal("765.2"));

        Conta conta5 = insereConta("Alexandre Duarte", "104 - CAIXA ECONOMICA FEDERAL", "1234", "98654-3");
        insereMovimentacao(conta5, Calendar.getInstance(), "Salario - ABRIL/2012", TipoMovimentacao.ENTRADA, new BigDecimal("2651.9"));
        insereMovimentacao(conta5, Calendar.getInstance(), "Bonus - JANEIRO/2012", TipoMovimentacao.ENTRADA, new BigDecimal("1000"));
    }

    private static Conta insereConta(String titular, String banco, String agencia, String numero) {
	Conta conta = new Conta();
	conta.setTitular(titular);
	conta.setBanco(banco);
	conta.setAgencia(agencia);
	conta.setNumero(numero);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(conta);

        manager.getTransaction().commit();
        manager.close();

        return conta;
    }

    private static Movimentacao insereMovimentacao(Conta conta, Calendar data, String descricao, TipoMovimentacao tipoMovimentacao, BigDecimal valor) {
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setConta(conta);
        movimentacao.setData(data);
        movimentacao.setDescricao(descricao);
        movimentacao.setTipoMovimentacao(tipoMovimentacao);
        movimentacao.setValor(valor);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(movimentacao);

        manager.getTransaction().commit();
        manager.close();

        return movimentacao;
    }

    private static void buscaEAtualizaConta() {
	EntityManager manager = new JPAUtil().getEntityManager();
	manager.getTransaction().begin();

	Conta conta = manager.find(Conta.class, 1);
	System.out.println(conta.getTitular());

        // Alterando o titular da conta
        conta.setTitular("Luiz Ferreira");

        System.out.println(conta.getTitular());

	manager.getTransaction().commit();
	manager.close();
    }
}