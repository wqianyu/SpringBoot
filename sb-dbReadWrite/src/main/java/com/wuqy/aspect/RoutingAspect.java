package com.wuqy.aspect;

import com.wuqy.annotation.RoutingWith;
import com.wuqy.routing.RoutingDataSource;
import com.wuqy.service.intf.DataSourceNames;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class RoutingAspect implements Ordered {
    @Pointcut("@annotation(com.wuqy.annotation.RoutingWith)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        RoutingWith ds = method.getAnnotation(RoutingWith.class);
        if (ds == null) {
            RoutingDataSource.setDataSource(DataSourceNames.FIRST);
            log.info("set datasource is " + DataSourceNames.FIRST);
        } else {
            RoutingDataSource.setDataSource(ds.value());
            log.info("set datasource is " + ds.value());
        }

        try {
            return point.proceed();
        } finally {
            RoutingDataSource.clearDataSource();
            log.info("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
