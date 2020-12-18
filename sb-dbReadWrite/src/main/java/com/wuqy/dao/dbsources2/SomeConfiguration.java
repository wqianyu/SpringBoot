package com.wuqy.dao.dbsources2;

import com.wuqy.routing.RoutingDataSource;
import com.wuqy.service.intf.DataSourceNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class SomeConfiguration {
    @Bean(name = "masterDatasource")
//    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDatasource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }
//
//    /*@Bean
//    @Primary
//    public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name = "secondJdbcTemplate")
//    public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDatasource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }*/
//
//    @Bean(name = "jdbcTemplate")
//    public JdbcTemplate getReadOnlyJdbcTemplate() {
//        return new JdbcTemplate(secondDataSource());
//    }
//
//    @Bean(name = "slaveJdbcTemplate")
//    public JdbcTemplate getPrimaryJdbcTemplate() {
//        return new JdbcTemplate(primaryDataSource());
//    }

    @Bean(name="routingDataSource")
    @Primary
    public RoutingDataSource dataSource(@Qualifier("masterDatasource")DataSource primaryDataSource,
            @Qualifier("secondDatasource")DataSource secondDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DataSourceNames.FIRST, primaryDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new RoutingDataSource(primaryDataSource, targetDataSources);
    }
}
