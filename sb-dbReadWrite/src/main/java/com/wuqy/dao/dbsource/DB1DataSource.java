package com.wuqy.dao.dbsource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(
//        basePackages = "com.wuqy.dao.mapper",
//        sqlSessionFactoryRef = "db1SqlSessionFactory"
//)
public class DB1DataSource {

    @Bean("db1MybatisProperties")
    @ConfigurationProperties("project.datasource.db1.mybatis")
    public MybatisProperties mybatisProperties(){
        return new MybatisProperties();
    }


    @Bean("db1DataSourceProperties")
    @ConfigurationProperties("project.datasource.db1")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean("db1DS")
    @ConfigurationProperties("project.datasource.db1.configuration")
    public DataSource dataSource(@Qualifier("db1DataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean("db1TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("db1DS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("db1TransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("db1TransactionManager") PlatformTransactionManager transactionManager){
        return new TransactionTemplate(transactionManager);
    }

    @Bean("db1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("db1MybatisProperties") MybatisProperties mybatisProperties,
            @Qualifier("db1DS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());
        sessionFactoryBean.setMapperLocations(mybatisProperties.resolveMapperLocations());
        return sessionFactoryBean.getObject();
    }

}
