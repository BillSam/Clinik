package interceptors;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Created by error on 3/7/18.
 */
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface InterceptedBean {
}
