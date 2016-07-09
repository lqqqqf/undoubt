package com.lqqqqf.common;

import java.lang.annotation.*;

/**
 * Created by apple on 16/6/25.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Escape {

    String[] value() default "";

}
