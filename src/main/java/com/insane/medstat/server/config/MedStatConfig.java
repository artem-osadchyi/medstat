package com.insane.medstat.server.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.insane.medstat.server.service.JdbcBloodDataServiceImpl;
import com.insane.medstat.shared.service.BloodDataService;

@Configuration
public class MedStatConfig {
	// TODO: Move to properties file
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/medstat";
	public static final String JDBC_USERNAME = "root";
	public static final String JDBC_PASSWORD = "root";

	@Bean
	public BloodDataService blood() {
		JdbcBloodDataServiceImpl dao = new JdbcBloodDataServiceImpl();

		dao.setDataSource(bloodDataSource());

		return dao;
	}

	@Bean
	public DataSource bloodDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();

		source.setDriverClassName(JDBC_DRIVER);
		source.setUrl(JDBC_URL);
		source.setUsername(JDBC_USERNAME);
		source.setPassword(JDBC_PASSWORD);

		return source;
	}

}