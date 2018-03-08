package interceptors;

import javax.interceptor.InterceptorBinding;

/**
 * Created by error on 3/7/18.
 */
@InterceptedBean
public class ClassBean {

    public void printString(){
        System.out.println("Intercepted method");

    }

}
