package com.wuqy.routing;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages = "com.wuqy.dao.mapper",
        sqlSessionFactoryRef = "routingSqlSessionFactory"
)
public class MybatisConfig {

    @Resource(name="routingDataSource")
    private DataSource dataSource;

    @Bean("mybatisProperties")
    @ConfigurationProperties("spring.datasource.mybatis")
    public MybatisProperties masterProperties(){
        return new MybatisProperties();
    }


    @Bean("routingSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("mybatisProperties") MybatisProperties mybatisProperties) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfiguration(mybatisProperties.getConfiguration());
        factoryBean.setMapperLocations(mybatisProperties.resolveMapperLocations());
        return factoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
