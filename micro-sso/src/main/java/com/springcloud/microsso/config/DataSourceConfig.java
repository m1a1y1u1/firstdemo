package com.springcloud.microsso.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/8/4 16:42 <br/>
 * @Author: 玄冥
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("datasource.sso")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("datasource.sso.configuration")
    public HikariDataSource firstDataSource() {
        DataSourceProperties properties = firstDataSourceProperties();
        return properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
}
