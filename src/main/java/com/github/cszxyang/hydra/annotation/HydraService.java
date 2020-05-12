package com.github.cszxyang.hydra.annotation;


import com.github.cszxyang.hydra.enums.DynamicProxyType;

import java.lang.annotation.*;

import static com.github.cszxyang.hydra.enums.DynamicProxyType.CGLIB;

/**
 * a tag annotation for rpc service
 *
 * @author cszxyang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HydraService {
    /** user-custom type of dynamic proxy **/
    String proxyType() default "CGLIB";

    /** type of serialization **/
    int serializationType() default 0;

}