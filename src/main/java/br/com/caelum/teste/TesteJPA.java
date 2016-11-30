package br.com.caelum.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteJPA {

    public static void main(String[] args) {

        insereConta();

        buscaEAtualizaConta();
    }

    private static void insereConta() {
	double inicio = System.currentTimeMillis();

	Conta conta = new Conta();
	conta.setTitular("Maria dos Santos");
	conta.setBanco("Caixa");
	conta.setAgencia("043");
	conta.setNumero("54321");

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(conta);

        manager.getTransaction().commit();
        manager.close();

	double fim = System.currentTimeMillis();
	System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
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