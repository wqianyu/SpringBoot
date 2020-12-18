package com.wuqy.annotation;

import com.wuqy.dao.condition.ReadOnlyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
@Conditional(ReadOnlyCondition.class)
public @interface ReadOnly {

    /**
     * 是否只读，默认是
     */
    boolean isReadOnly() default true;
}


