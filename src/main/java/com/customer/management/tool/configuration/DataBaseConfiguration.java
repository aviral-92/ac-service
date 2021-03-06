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
import org.springframework.util.StringUtils;

/**
 *
 * @author amittal
 */
@Component
public class DataBaseConfiguration {

	
	@Value("${isLocal:yes}")
	private String isLocal ;
	
	@Value("${db.mysql.driver:com.mysql.jdbc.Driver}")
	private String dbDriver;
	@Value("${db.mysql.url:jdbc:mysql://10.2.0.207:3306/customer_mgmt_tool}")
	private String dbURL;
	@Value("${db.mysql.username:root}")
	private String dbUsername;
	@Value("${db.mysql.password:root}")
	private String dbPassword;
	@Value("${db.pawel.jdbcurl}")
	private String pawelDbURL;
	@Value("${db.pawel.password}")
	private String pawelDbPassword;

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriver);
		if(!StringUtils.isEmpty(isLocal) && "yes".equalsIgnoreCase(isLocal)){
			dataSource.setUrl(dbURL);
			dataSource.setUsername(dbUsername);
			dataSource.setPassword(dbPassword);
		} else {
		dataSource.setUrl(pawelDbURL);
		dataSource.setPassword(pawelDbPassword);
		}
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}
