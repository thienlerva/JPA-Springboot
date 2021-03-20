package com.swagger.configure;

//import org.apache.ibatis.session.ExecutorType;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.TransactionIsolationLevel;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.jdbc.DatabaseDriver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = {"com.jmpc.swagger.mapper"},
//        sqlSessionFactoryRef = "dbSqlSessionFactory"
//)
//public class testdbConfiguration {
//
//    @Primary
//    @Bean
//    @ConfigurationProperties("swagger.datasource")
//    public DataSourceProperties swaggerDataSourceProperties() { return new DataSourceProperties(); }
//
//    @Primary
//    @Bean(name = "testdb")
//    @ConfigurationProperties(prefix = "swagger.datasource")
//    public DataSource dataSource() {
//        //return DataSourceBuilder.create().build();
//        return  swaggerDataSourceProperties().initializeDataSourceBuilder().build();
//    }
//
//    @Primary
//    @Bean(name = "testdbTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("testdb") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Primary
//    @Bean(name = "dbSqlSessionFactory")
//    @ConfigurationProperties("swagger.mybatis")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("testdb") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setTypeAliasesPackage("com.jmpc.swagger.model");
//        factoryBean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
//
//        return factoryBean.getObject();
//    }
//
////    @Primary
////    @Bean(name = "testdb")
////    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////
////        dataSource.setUrl("jdbc:mysql://localhost:3306/swagger?serverTimezone=UTC");
////        dataSource.setUsername("root");
////        dataSource.setPassword("password");
////
////        return  dataSource;
////    }
//}
