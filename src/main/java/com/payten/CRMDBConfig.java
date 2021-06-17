package com.payten;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "CRMEntityManagerFactory",
    transactionManagerRef = "CRMTransactionManager", basePackages = {"com.payten.crm.repository"})
public class CRMDBConfig {

	  @Bean(name = "CRMDataSource")
	  @ConfigurationProperties(prefix = "spring.datasource")
	  public DataSource dataSource() {
		  return DataSourceBuilder.create().build();
	  }

	  @Bean(name = "CRMEntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean crmEntityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("CRMDataSource") DataSource dataSource) {
	    return builder.dataSource(dataSource).packages("com.payten.crm.model").persistenceUnit("crm")
	        .build();
	  }

	  @Bean(name = "CRMTransactionManager")
	  public PlatformTransactionManager crmTransactionManager(
	      @Qualifier("CRMEntityManagerFactory") EntityManagerFactory crmEntityManagerFactory) {
	    return new JpaTransactionManager(crmEntityManagerFactory);
	  }
}
