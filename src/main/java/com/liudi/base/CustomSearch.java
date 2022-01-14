//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CustomSearch {
    String name() default "";

    boolean isShow() default false;

    String aliasName() default "";

    String rule() default "";

    String columnName() default "";

    boolean dateShow() default false;
}
