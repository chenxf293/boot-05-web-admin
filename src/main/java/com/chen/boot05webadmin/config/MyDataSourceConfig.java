package com.chen.boot05webadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSourceConfig {
//    默认的自动配置是判断容器中没有才会配@ConditionalOnMissingBean(DataSource.class)
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource(){

        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

}
