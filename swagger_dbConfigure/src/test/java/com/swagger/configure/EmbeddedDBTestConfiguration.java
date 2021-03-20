package com.swagger.configure;

import static com.swagger.configure.CAMPSDataSourceConfiguration.CAMPS_SESSION_FACTORY;

import com.swagger.SwaggerApplication;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Configuration
@Import(SwaggerApplication.class)
@MapperScan(basePackages = {
        "com.jmpc.swagger.mapper"
}, sqlSessionFactoryRef = CAMPS_SESSION_FACTORY)
public abstract class EmbeddedDBTestConfiguration {

    public static final String CAMPS_DATA_SOURCE = "campsDataSource";
    public static final String CAMPS_SESSION_FACTORY = "campsSessionFactory";

//    @Primary
//    @Bean(CAMPS_DATA_SOURCE)
//    @ConfigurationProperties("swagger.datasource")
//    public DataSource campsDataSource() {
//        return campsDataSourceProperties().initializeDataSourceBuilder().build();
//    }

    @Bean(CAMPS_SESSION_FACTORY)
    @ConfigurationProperties("swagger.mybatis")
    public SqlSessionFactoryBean campsSqlSessionFactory(@Qualifier(CAMPS_DATA_SOURCE) DataSource campsDataSource) throws Exception {

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(campsDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.jmpc.swagger.model");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Primary
    @Bean(CAMPS_DATA_SOURCE)
    public DataSource campsDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScripts("classpath:/schema.sql",
                        "classpath:/testdata.sql")
                .build();
    }

    @Bean
    public DBQueryConfig dbQueryConfig() {
        return new DBQueryConfig() {

            @Override
            public String platform() { return "H2"; }

            @Override
            public LocalDateTime getCurrentTimestampUTC() { return LocalDateTime.now(ZoneOffset.UTC); }
        };
    }

}
