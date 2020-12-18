package com.wuqy.autoconfig;

import com.wuqy.common.vo.BaseView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2
 */
@Configuration
public class WebConfiguration {

    @Bean
    public BaseView getBaseView(@Value("${spring.profiles.active}") String profile) {
        BaseView<String> baseView = new BaseView<>();
        baseView.setData(profile);
        return baseView;
    }
}
