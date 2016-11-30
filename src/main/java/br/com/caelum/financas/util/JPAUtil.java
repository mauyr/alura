package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mauyr on 30/11/16.
 */
public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory = Persistence
		    .createEntityManagerFactory("financas");

    public EntityManager getEntityManager() {
	return entityManagerFactory.createEntityManager();
    }
}
