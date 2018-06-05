package com.zoe.demo.config.muiltDataSource;

/**
 * Created by 陈亚兰 on 2018/6/4.
 */

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.zoe.demo.oracle", sqlSessionTemplateRef = "plmSqlSessionTemplate")
public class SqlSessionPLMOracle {



    @Bean(name = "plmSqlSessionFactory")
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("plmDataSource")
                                                                      DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper\\oracle\\*.xml"));
        return bean.getObject();
    }

    @Bean(name = "plmTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(  @Qualifier("plmDataSource")
                                                                                DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "plmSqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate(
            @Qualifier("plmSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}