package com.wuqy.common.log;

import java.lang.annotation.*;

/**
 * 自定义注解：拦截controller操作，记录日志
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ManagerLog {

    /**
     * 模块
     */
    String module() default "";

    /**
     * 动作：登录、注销、新增关键词、删除关键词、修改关键词
     */
    String operate() default "";
}

