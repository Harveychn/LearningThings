package annotation;

import java.lang.annotation.*;

/**
 * [author]:  zhengxiaohui  ;
 * [create date]: 2020/8/31 13:45
 * [description]:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FruitProvider {

    int id() default -1;

    String name() default "";

    String address() default "";
}
