/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author amittal
 */
@Component
public class DataBaseConfiguration {

	@Value("${db.mysql.driver}")
	private String dbDriver;
	@Value("${db.mysql.url}")
	private String dbURL;
	@Value("${db.mysql.username}")
	private String dbUsername;
	@Value("${db.mysql.password}")
	private String dbPassword;
	@Value("${db.pawel.jdbcurl}")
	private String pawelDbURL;
	@Value("${db.pawel.password}")
	private String pawelDbPassword;

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(pawelDbURL);
		dataSource.setPassword(pawelDbPassword);
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}
