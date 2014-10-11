package com.insane.medstat.server.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.insane.medstat.shared.dto.BloodDataItem;
import com.insane.medstat.shared.service.BloodDataService;

public class JdbcBloodDataServiceImpl extends NamedParameterJdbcDaoSupport
		implements BloodDataService {
	// TODO: Move it somewhere
	public static final String TABLE_NAME = "medstat";

	private SimpleJdbcInsert bloodDataItemInsert;

	@Override
	protected void initTemplateConfig() {
		super.initTemplateConfig();
		this.bloodDataItemInsert = new SimpleJdbcInsert(getJdbcTemplate())
				.withTableName(TABLE_NAME);
	}

	public SimpleJdbcInsert getBloodDataItemInsert() {
		return bloodDataItemInsert;
	}

	public void add(BloodDataItem item) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(item);
		getBloodDataItemInsert().execute(parameters);
	}

	public ArrayList<BloodDataItem> get(Long patientId, Date start, Date end) {
		// TODO: Implement
		return null;
	}

}