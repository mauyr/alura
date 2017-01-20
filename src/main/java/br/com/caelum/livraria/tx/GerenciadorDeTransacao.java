package br.com.caelum.livraria.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by mauyr on 20/01/17.
 */

@Transactional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {

    @Inject
    EntityManager manager;

    @AroundInvoke
    public Object executaTX(InvocationContext context) throws Exception {

        manager.getTransaction().begin();

        // chamar os daos que precisam de um TX
        Object object = context.proceed();

        manager.getTransaction().commit();

        return object;
    }
}
