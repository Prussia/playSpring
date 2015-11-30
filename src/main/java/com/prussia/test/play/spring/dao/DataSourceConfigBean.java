package com.prussia.test.play.spring.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@Profile("dev")
public class DataSourceConfigBean {

	private static final Logger log = LoggerFactory.getLogger(DataSourceConfigBean.class);

	DataSource dataSource;
	
	ResourceBundleMessageSource messageSource;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	@Description("MySql data source")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}
	
}
