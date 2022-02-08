package com.cristianriano.movies.config;

import java.util.Properties;
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
  private static final String HIBERNATE_DDL_AUTO = "hibernate.hbm2ddl.auto";
  public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

  @Bean(name = DATASOURCE_PROPERTIES)
  // This will load the properties matching the given prefix.
  // Is not needed since we use the default spring datasource properties prefix, is only for the example
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSourceProperties dataSourceProperties() {
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
//    jpaVendorAdapter.setGenerateDdl(true);
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

    Properties properties = new Properties();
    properties.setProperty(HIBERNATE_DDL_AUTO, "update");
    // Should only be enabled for tests
    properties.setProperty(HIBERNATE_SHOW_SQL, "true");
    lemfb.setJpaProperties(properties);

    return lemfb;
  }
}
