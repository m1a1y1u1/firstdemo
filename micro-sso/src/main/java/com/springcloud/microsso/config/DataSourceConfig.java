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
    public DataSourceProperties ssoDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("datasource.sso.configuration")
    public HikariDataSource ssoDataSource() {
        DataSourceProperties properties = ssoDataSourceProperties();
        return properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
}
