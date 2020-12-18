package com.wuqy.controller;

import com.wuqy.annotation.RoutingWith;
import com.wuqy.common.vo.BaseView;
import com.wuqy.service.T1Service;
import com.wuqy.service.T2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {
   /* @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    JdbcTemplate secondJdbcTemplate;*/

   @Autowired
   private T1Service t1Service;

    @Autowired
    private T2Service t2Service;

    @RequestMapping("/main")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/demo")
    @ResponseBody
    public BaseView demo() {
        /*List<T1> list1 = jdbcTemplate.query("select * from t1", new RowMapper<T1>() {
            @Override
            public T1 mapRow(ResultSet resultSet, int i) throws SQLException {
                return T1.builder().id(resultSet.getInt("id")).build();
            }
        });
        List<T1> list2 = secondJdbcTemplate.query("select * from t1", new RowMapper<T1>() {
            @Override
            public T1 mapRow(ResultSet resultSet, int i) throws SQLException {
                return T1.builder().id(resultSet.getInt("id")).build();
            }
        });*/

        return new BaseView("demo");
    }

    @GetMapping("/demo2")
    @ResponseBody
    public BaseView demo2() {
        t1Service.query1();
        t1Service.query2();
        t1Service.query3();
//        t2Service.query();
//        t3Service.insertIntoT1(T1.builder().build());
        return new BaseView("demo");
    }

    @GetMapping("/demo3")
    @ResponseBody
    public BaseView demo3() {
//        String key = "secondDatasource";
        t1Service.query1();
//        try (RoutingDataSourceContext ctx = new RoutingDataSourceContext(key)) {
//            t1Service.insertIntoT1(T1.builder().build());

            return new BaseView("demo");
//        }
    }

    @GetMapping("/exception")
    @ResponseBody
    public BaseView exception() throws Exception {
        throw new Exception("test");
    }
}
