package com.wuqy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件，前缀为wuqy-config的配置，属性填充
 */
@Component
@ConfigurationProperties(prefix = "wuqy-config")
@Data
public class ConfigProperties {

    /**
     * 需要get set才能获取
     */
    private String size;
}
