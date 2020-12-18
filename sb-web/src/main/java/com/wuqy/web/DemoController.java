package com.wuqy.web;

import com.wuqy.common.vo.BaseView;
import com.wuqy.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController extends BaseController{

    @Autowired
    ConfigProperties configProperties;

    @Value("${spring.profiles.active}")
    private String profile;

    /**
     * 通过自定义自动装配WebConfiguration获取baseView
     */
    @Autowired
    private BaseView baseView;

    @GetMapping("/demo")
    @ResponseBody
    public BaseView demo() {
        return renderData("demo");
    }
}
