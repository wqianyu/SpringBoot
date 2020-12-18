package com.wuqy.dao.condition;

import com.wuqy.annotation.ReadOnly;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class NoReadOnlyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(ReadOnly.class.getName());
        if(null != annotationAttributes && null != annotationAttributes.get("noReadOnly")) {
            Boolean noReadOnly = (Boolean)annotationAttributes.getOrDefault("noReadOnly", "true");
            return noReadOnly;
        }
        return false;
    }
}
