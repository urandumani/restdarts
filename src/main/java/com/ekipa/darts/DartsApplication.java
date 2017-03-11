package com.ekipa.darts;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.h2.server.web.WebServlet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author urandumani
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.ekipa" })
@EnableTransactionManagement
public class DartsApplication {
	
	@Value("${spring.datasource.driver}")
    private String databaseDriver;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePass;
    
    @Value("${spring.datasource.hibernateDialect}")
    private String hibernateDialect;

    public static void main(String[] args) {
        SpringApplication.run(DartsApplication.class, args);
    }
    
    @Bean
    public SessionFactory sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.ekipa").addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }
    
    @Bean
    public ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
    
    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(databaseDriver);
        ds.setJdbcUrl(databaseUrl);
        ds.setUser(databaseUsername);
        ds.setPassword(databasePass);
        return ds;
    }
    
    @Bean(name = "txManager")
    @Primary
    public HibernateTransactionManager txManager() throws PropertyVetoException {
        return new HibernateTransactionManager(sessionFactory());
    }
    
    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", hibernateDialect);
        return prop;
    }
}