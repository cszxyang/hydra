package com.github.cszxyang.hydra.annotation;

import java.lang.annotation.*;

/**
 * a tag annotation for rpc service
 *
 * @author cszxyang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HydraService {
    /** user-custom type of dynamic proxy **/
    int proxyType() default 0;

    /** type of serialization **/
    int serializationType() default 0;

}