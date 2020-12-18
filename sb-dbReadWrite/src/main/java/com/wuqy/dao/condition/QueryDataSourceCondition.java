package com.wuqy.dao.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.jdbc.core.JdbcTemplate;

public class QueryDataSourceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        conditionContext.getBeanFactory().getBean(JdbcTemplate.class);
        annotatedTypeMetadata.isAnnotated("jdbcTemplate");
        return false;
    }
}
