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

        long inicio = System.currentTimeMillis();

        Object object = context.proceed();

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println(context.getMethod().getDeclaringClass().getName() + "." + context.getMethod().getName() + " >> " + tempoDeExecucao);

        return object;
    }
}
