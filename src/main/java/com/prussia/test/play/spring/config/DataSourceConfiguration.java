package com.prussia.test.play.spring.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DataSourceConfiguration {

	private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);

	DataSource dataSource;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	@Description("msSql data source")
	public DataSource getDataSource() {
		DataSource ds =  DataSourceBuilder.create().build();
		return ds;
	}
	
}
