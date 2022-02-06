package com.cristianriano.movies.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories("com.cristianriano.movies.repositories")
public class JpaConfiguration {

  private static final String DATASOURCE_PROPERTIES = "DATASOURCE_PROPERTIES";

  @Bean(name = DATASOURCE_PROPERTIES)
  // For the sake of this example we re-use the default spring datasource properties prefix
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSourceProperties readerDataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean
  public DataSource dataSource(@Qualifier(DATASOURCE_PROPERTIES) DataSourceProperties dsProps) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(dsProps.getDriverClassName());
    dataSource.setUrl(dsProps.getUrl());
    dataSource.setUsername(dsProps.getUsername());
    dataSource.setPassword(dsProps.getPassword());
    return dataSource;
  }

  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    return new JpaTransactionManager(emf);
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabase(Database.MYSQL);
    jpaVendorAdapter.setGenerateDdl(true);
    return jpaVendorAdapter;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      @Qualifier(DATASOURCE_PROPERTIES) DataSourceProperties dsProps
  ) {
    LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
    lemfb.setDataSource(dataSource(dsProps));
    lemfb.setJpaVendorAdapter(jpaVendorAdapter());
    lemfb.setPackagesToScan("com.cristianriano.movies.entities");
    return lemfb;
  }
}
