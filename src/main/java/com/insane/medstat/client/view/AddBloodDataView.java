package com.insane.medstat.client.view;

import java.util.Date;

public interface AddBloodDataView {

	long getId();

	long getPatientId();

	Date getTimestamp();

	int getSystolic();

	int getDiastolic();

	int getPulse();

	String getComment();

}