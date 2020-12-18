package com.wuqy.dao.condition;

import com.wuqy.annotation.ReadOnly;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class ReadOnlyCondition implements Condition {

    /**
     * 此种情况只能2选1，因为autowire是单例的，不能动态切换数据源
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(ReadOnly.class.getName());
        if(null != annotationAttributes && null != annotationAttributes.get("isReadOnly")) {
            Boolean isReadOnly = (Boolean)annotationAttributes.getOrDefault("isReadOnly", "true");
            return isReadOnly;
        }
        return false;
    }
}
