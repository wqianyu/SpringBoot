package com.wuqy.service;

import com.wuqy.common.entity.db.TOrder;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    public void insert() {
        jdbcTemplate.execute("INSERT INTO t_order (user_id, order_id) VALUES (?, ?)", (PreparedStatementCallback<Object>) ps -> {
            ps.setObject(1, 1);
            ps.setObject(2, 2);
            return ps.executeUpdate();
        });
    }
}
