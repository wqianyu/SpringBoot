package com.wuqy.autoconfig;

import com.alibaba.fastjson.JSONObject;
import com.wuqy.common.vo.BaseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * 1、将App标记为@EnableAutoConfiguration，并作为App.run方法的首参
 * 没有springMvc功能
 */
@EnableAutoConfiguration
public class App 
{
    @Autowired
    static BaseView baseView;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

        System.out.println(JSONObject.toJSONString(baseView));
    }
}
