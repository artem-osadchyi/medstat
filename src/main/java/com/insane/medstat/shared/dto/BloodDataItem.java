package com.insane.medstat.shared.dto;

import java.io.Serializable;

public class BloodDataItem implements Serializable {
	private static final long serialVersionUID = -1720158304172289195L;

	private long id;
	private long patientId;
	private int systolic;
	private int diastolic;
	private int pulse;
	private String comment;

	public BloodDataItem(long id, long patientId, int systolic, int diastolic,
			int pulse, String comment) {
		this.id = id;
		this.patientId = patientId;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse = pulse;
		this.comment = comment;
	}

	public BloodDataItem() {
	}

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

		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + diastolic;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + pulse;
		result = prime * result + systolic;

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
		if (comment == null) {
			if (other.comment != null) {
				return false;
			}
		}
		else if (!comment.equals(other.comment)) {
			return false;
		}

		if (diastolic != other.diastolic) {
			return false;
		}

		if (id != other.id) {
			return false;
		}

		if (patientId != other.patientId) {
			return false;
		}

		if (pulse != other.pulse) {
			return false;
		}

		if (systolic != other.systolic) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "BloodDataItem [id=" + id + ", patientId=" + patientId
				+ ", systolic=" + systolic + ", diastolic=" + diastolic
				+ ", pulse=" + pulse + ", comment=" + comment + "]";
	}

}