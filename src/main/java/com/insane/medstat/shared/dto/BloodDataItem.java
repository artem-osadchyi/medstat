package com.insane.medstat.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class BloodDataItem implements Serializable {
	private static final long serialVersionUID = -1720158304172289195L;

	private long id;
	private long patientId;
	private Date timestamp;
	private int systolic;
	private int diastolic;
	private int pulse;
	private String comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + (int) (id ^ (id >>> 32));

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof BloodDataItem)) {
			return false;
		}

		BloodDataItem other = (BloodDataItem) obj;

		return this.id == other.getId();
	}

	@Override
	public String toString() {
		return "BloodDataItem [id=" + id + ", patientId=" + patientId
				+ ", timestamp=" + timestamp + ", systolic=" + systolic
				+ ", diastolic=" + diastolic + ", pulse=" + pulse
				+ ", comment=" + comment + "]";
	}

}