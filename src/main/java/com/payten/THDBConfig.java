package com.payten;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "THEntityManagerFactory", transactionManagerRef = "THTransactionManager", basePackages = {
		"com.payten.termhost.repository" })
public class THDBConfig {
	@Primary
	@Bean(name = "THDataSource")
	@ConfigurationProperties(prefix = "termhost.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "THEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean thEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("THDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.payten.termhost.model").persistenceUnit("termhost").build();
	}

	@Primary
	@Bean(name = "THTransactionManager")
	public PlatformTransactionManager thTransactionManager(
			@Qualifier("THEntityManagerFactory") EntityManagerFactory thEntityManagerFactory) {
		return new JpaTransactionManager(thEntityManagerFactory);
	}

}
