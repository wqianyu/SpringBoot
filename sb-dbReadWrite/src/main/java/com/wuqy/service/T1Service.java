package com.wuqy.service;

import com.alibaba.fastjson.JSONObject;
import com.wuqy.annotation.NoReadOnly;
import com.wuqy.annotation.RoutingWith;
import com.wuqy.common.entity.db.T1;
import com.wuqy.common.entity.db.T1Example;
import com.wuqy.dao.mapper.T1Mapper;
import com.wuqy.service.intf.DataSourceNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class T1Service {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @RoutingWith(value = DataSourceNames.FIRST)
//    public void insertIntoT1(T1 entity) {
//        List<T1> t1 = jdbcTemplate.query("select * from t1", new RowMapper<T1>() {
//            @Override
//            public T1 mapRow(ResultSet resultSet, int i) throws SQLException {
//                return T1.builder().id(resultSet.getInt("id")).build();
//            }
//        });
//        log.info("insertIntoT1:"+JSONObject.toJSONString(t1));
//    }
//
//    public void queryT1() {
//        List<T1> t1 = jdbcTemplate.query("select * from t1", new RowMapper<T1>() {
//            @Override
//            public T1 mapRow(ResultSet resultSet, int i) throws SQLException {
//                return T1.builder().id(resultSet.getInt("id")).build();
//            }
//        });
//        log.info("queryT1:"+JSONObject.toJSONString(t1));
//    }

    @Autowired
    private T1Mapper t1Mapper;

    public void query1() {
        List<T1> t1 = t1Mapper.selectByExample(new T1Example());
        log.info("queryT1:"+JSONObject.toJSONString(t1));
    }

    @RoutingWith(value = DataSourceNames.SECOND)
    public void query2() {
        List<T1> t1 = t1Mapper.selectByExample(new T1Example());
        log.info("queryT1:"+JSONObject.toJSONString(t1));
    }


    @RoutingWith(value = DataSourceNames.FIRST)
    public void query3() {
        List<T1> t1 = t1Mapper.selectByExample(new T1Example());
        log.info("queryT1:"+JSONObject.toJSONString(t1));
    }
}
