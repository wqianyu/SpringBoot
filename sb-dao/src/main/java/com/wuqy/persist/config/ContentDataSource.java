package com.wuqy.persist.config;

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

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = "com.wuqy.persist.mapper.content",
        sqlSessionFactoryRef = "contentSqlSessionFactory"
)
public class ContentDataSource {

    @Bean("contentMybatisProperties")
    @ConfigurationProperties("project.datasource.content.mybatis")
    public MybatisProperties mybatisProperties(){
        return new MybatisProperties();
    }


    @Bean("contentDataSourceProperties")
    @ConfigurationProperties("project.datasource.content")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean("contentDS")
    @ConfigurationProperties("project.datasource.content.configuration")
    public DataSource dataSource(@Qualifier("contentDataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean("contentTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("contentDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("contentTransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("contentTransactionManager") PlatformTransactionManager transactionManager){
        return new TransactionTemplate(transactionManager);
    }

    @Bean("contentSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("contentMybatisProperties") MybatisProperties mybatisProperties,
            @Qualifier("contentDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());
        sessionFactoryBean.setMapperLocations(mybatisProperties.resolveMapperLocations());
        return sessionFactoryBean.getObject();
    }

}
