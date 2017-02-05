package com.cengenes.springmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cengenes.springmvc.service.BlogPostService;
import com.cengenes.springmvc.service.imp.BlogPostServiceImp;






/*
 *  We use especially ApplicationContext class name to understand
 *  It is configration class such as DB etc (not use XML like application context.xml)
 */
@EnableJpaRepositories(basePackages={"com.cengenes.springmvc.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

	@Autowired
	private Environment environment;
	
	@Bean(name="MySQLDs")
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		
		return dataSource;
		
	}
	
	
	@Bean
	public BlogPostService blogPostService(){
		
		return new BlogPostServiceImp();
	}
	
	private DatabasePopulator databasePopulator(){
		
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("test-data.sql"));
		return databasePopulator;
		
		
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
		
	}
	
	
	@Bean(name="embeddedDs")
	public DataSource dataSourceEmbedded(){
	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	
	EmbeddedDatabase embededDatabase = builder.setType(EmbeddedDatabaseType.HSQL)
			.addScript("dbschema.sql")
			.addScript("test-data.sql")
			.build();
	
	return embededDatabase;
	
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory){
		
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		DatabasePopulatorUtils.execute(databasePopulator(), dataSource());
		return jpaTransactionManager;
	}
	
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean (){
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.cengenes.springmvc.model");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.setProperty("show_sql", "true");
		
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		return entityManagerFactoryBean;
	} 
	
	
}
