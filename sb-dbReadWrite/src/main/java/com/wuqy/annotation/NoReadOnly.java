package com.wuqy.annotation;

import com.wuqy.dao.condition.NoReadOnlyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(NoReadOnlyCondition.class)
public @interface NoReadOnly {

    /**
     * 是否只读，默认是
     */
    boolean noReadOnly() default true;
}


