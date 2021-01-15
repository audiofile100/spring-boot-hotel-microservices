package com.synergisticit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Slf4j
@Configuration
@PropertySource(value = {"classpath:db.properties"})
@ComponentScan(basePackages = {"com.synergisticit"})
@EnableJpaRepositories(basePackages = {"com.synergisticit.repository"})
public class AppConfig {

    private Environment env;

    @Autowired
    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        log.debug("AppConfig.dataSource()......");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setUsername(env.getProperty("dbUsername"));
        dataSource.setPassword(env.getProperty("dbPassword"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        log.debug("AppConfig.entityManagerFactory()......");

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.synergisticit.domain");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(jpaProperties());

        return entityManagerFactory;
    }

    private Properties jpaProperties() {

        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.show_SQL", "true");

        return jpaProperties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        log.debug("AppConfig.transactionManager()......");

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(dataSource());

        return jpaTransactionManager;
    }

}
