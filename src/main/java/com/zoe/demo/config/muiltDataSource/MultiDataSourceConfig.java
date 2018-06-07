//package com.zoe.demo.config.muiltDataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
///**
// * Created by 陈亚兰 on 2018/6/4.
// */
//@Configuration
//public class MultiDataSourceConfig {
//    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")
//    @Primary // 定义主数据源
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "plmDataSource")
//    @Qualifier("plmDataSource")
//    @ConfigurationProperties(prefix = "custom.datasource")
//    public DataSource plmDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
