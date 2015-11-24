package com.prussia.test.play.spring.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.prussia.test.play.spring.domain.Customer;

@Service
public class BaseDao {

	private static final Logger log = LoggerFactory.getLogger(BaseDao.class);

	DataSource dataSource;

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

}
