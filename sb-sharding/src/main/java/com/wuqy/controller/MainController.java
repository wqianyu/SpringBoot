package com.wuqy.controller;

import com.wuqy.common.vo.BaseView;
import com.wuqy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/demo")
    @ResponseBody
    public BaseView demo() {
        try {
            orderService.insert();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseView("demo");
    }

}
