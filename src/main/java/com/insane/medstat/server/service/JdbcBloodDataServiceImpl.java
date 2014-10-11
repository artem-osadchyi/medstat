package com.insane.medstat.server.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
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
	public static final String GET_ITEMS_QUERY = "select * from " + TABLE_NAME;

	public static class BloodDataItemRowMapper implements
			RowMapper<BloodDataItem> {

		@Override
		public BloodDataItem mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			BloodDataItem item = new BloodDataItem();

			item.setId(rs.getLong("id"));
			item.setPatientId(rs.getLong("patientId"));
			item.setTimestamp(rs.getDate("timestamp"));
			item.setSystolic(rs.getInt("systolic"));
			item.setDiastolic(rs.getInt("diastolic"));
			item.setPulse(rs.getInt("pulse"));
			item.setComment(rs.getString("comment"));

			return item;
		}

	}

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
		RowMapper<BloodDataItem> mapper = new BloodDataItemRowMapper();
		ArrayList<BloodDataItem> items = new ArrayList<BloodDataItem>(
				getJdbcTemplate().query(GET_ITEMS_QUERY, mapper));
		return items;
	}

}