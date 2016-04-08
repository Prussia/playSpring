package com.prussia.test.play.spring.web.secure.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class DSConfiguration {
	@Bean
	public DataSource dataSource1() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("****");
		return ds;
	}
}
