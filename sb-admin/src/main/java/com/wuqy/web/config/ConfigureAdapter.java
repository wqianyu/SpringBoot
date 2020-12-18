package com.wuqy.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 * @author wuqy
 * 2020-11-27
 */
@Configuration
public class ConfigureAdapter implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] domains = new String[]{
                "webtest.yy.com", "www.yy.com", "www.duowan.cn","www.duowan.com.cn",
                "www.duowan.com", "duowan.com.cn", "test.duowan.com", "dw.yy.com", "dwdata.yy.com"
        };
        int size = domains.length * 2;
        String[] origins = new String[size];
        for(int index = 0 ; index < domains.length; index++){
            origins[index * 2] = "http://" + domains[index];
            origins[index * 2 + 1] = "https://" + domains[index];
        }
        /*if(!DragonEnv.isProduce()){
            List<String> originList = new ArrayList<String>(Arrays.asList(origins));
            originList.add("*");
            origins = new String[originList.size()];
            originList.toArray(origins);
        }*/
        registry.addMapping("/**")
                .allowedOrigins(origins)
                .allowedHeaders("*")
                .allowedMethods("GET", "POST","OPTIONS")
                .allowCredentials(true);




    }
}