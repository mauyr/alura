package br.com.caelum.livraria.log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mauyr on 20/01/17.
 */
@LogTime
@Interceptor
public class TempoDeExecucaoInterceptor implements Serializable {

    @AroundInvoke
    public Object analisaTempo(InvocationContext context) throws Exception {
        System.out.println("[Inicio] " + context.getMethod().getDeclaringClass().getName() + "." + context.getMethod().getName() + " >> " + new Date());

        Object object = context.proceed();

        System.out.println("[Fim] " + context.getMethod().getDeclaringClass().getName() + "." + context.getMethod().getName() + " >> " + new Date());

        return object;
    }
}
