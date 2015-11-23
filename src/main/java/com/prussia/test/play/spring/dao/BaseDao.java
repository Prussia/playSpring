package com.prussia.test.play.spring.dao;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

public class BaseDao {

	private DataSource dataSource;
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource getDataSource(){
		return DataSourceBuilder.create().build(); 
	}
}
