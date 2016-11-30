package br.com.caelum.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteJPA {

    public static void main(String[] args) {

        insertConta();

        insertConta();
    }

    private static void insertConta() {
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
}