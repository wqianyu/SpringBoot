package com.wuqy.autoconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 3、创建自动装配类WebAutoConfiguration，并使用@Import导入WebConfiguration
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}
