package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by error on 3/7/18.
 */
@Interceptor
@InterceptedBean
public class InterceptorClass {

    @AroundInvoke
    public Object printString(InvocationContext ctx){

        System.out.println("Intercepting");

        try {
            ctx.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Object();

    }
}
