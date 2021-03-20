package com.swagger.configure;

import static com.swagger.configure.CAMPSDataSourceConfiguration.CAMPS_SESSION_FACTORY;

import org.springframework.beans.factory.annotation.Qualifier;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {
        "com.swagger.mapper"
}, sqlSessionFactoryRef = CAMPS_SESSION_FACTORY)
public class CAMPSDataSourceConfiguration {

    public static final String CAMPS_DATA_SOURCE = "campsDataSource";
    public static final String CAMPS_SESSION_FACTORY = "campsSessionFactory";

    @Primary
    @Bean
    @ConfigurationProperties("swagger.datasource")
    public DataSourceProperties campsDataSourceProperties() { return new DataSourceProperties(); }

    @Primary
    @Bean(CAMPS_DATA_SOURCE)
    @ConfigurationProperties("swagger.datasource")
    public DataSource campsDataSource() {
        return campsDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(CAMPS_SESSION_FACTORY)
    @ConfigurationProperties("swagger.mybatis")
    public SqlSessionFactoryBean campsSqlSessionFactory(@Qualifier(CAMPS_DATA_SOURCE) DataSource campsDataSource) throws Exception {

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(campsDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.swagger.model");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public DBQueryConfig dbQueryConfig()
    { return new DBQueryConfig(); }
}
