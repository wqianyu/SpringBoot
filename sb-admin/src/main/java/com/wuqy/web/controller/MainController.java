package com.wuqy.web.controller;

import com.wuqy.common.log.ManagerLog;
import com.wuqy.common.vo.BaseView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController extends BaseController{

    @ManagerLog(module="测试", operate = "hello")
    @RequestMapping("/main")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @ManagerLog(module="测试", operate = "test")
    @GetMapping("/demo")
    @ResponseBody
    public BaseView demo() {
        return renderData("demo");
    }

    @ManagerLog(module="测试", operate = "exception")
    @GetMapping("/exception")
    @ResponseBody
    public BaseView exception() throws Exception {
        throw new Exception("test");
    }
}
