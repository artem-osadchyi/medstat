package com.insane.medstat.shared.dto;

import static com.insane.medstat.shared.constants.BloodDataItemConstants.*;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class BloodDataItem implements Serializable {
	private static final long serialVersionUID = -1720158304172289195L;

	@NotNull(message = ID_NULL_MESSAGE)
	private Long id;

	@NotNull(message = PATIENT_ID_NULL_MESSAGE)
	private Long patientId;

	@Past(message = TIMESTAMP_FUTURE_MESSAGE)
	@NotNull(message = TIMESTAMP_NULL_MESSAGE)
	private Date timestamp;

	@Min(value = MIN_SYSTOLIC_VALUE, message = SYSTOLIC_LOW_MESSAGE)
	@Max(value = MAX_SYSTOLIC_VALUE, message = SYSTOLIC_HIGH_MESSAGE)
	private Integer systolic;

	@Min(value = MIN_DIASTOLIC_VALUE, message = DIASTOLIC_LOW_MESSAGE)
	@Max(value = MAX_DIASTOLIC_VALUE, message = DIASTOLIC_HIGH_MESSAGE)
	private Integer diastolic;

	@Min(value = MIN_PULSE_VALUE, message = PULSE_LOW_MESSAGE)
	@Max(value = MAX_PULSE_VALUE, message = PULSE_HIGH_MESSAGE)
	private Integer pulse;

	@Pattern(regexp = COMMENT_PATTERN, message = COMMENT_MATCH_MESSAGE)
	@Size(min = MIN_COMMENT_SIZE, max = MAX_COMMENT_SIZE, message = COMMENT_SIZE_MESSAGE)
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getSystolic() {
		return systolic;
	}

	public void setSystolic(Integer systolic) {
		this.systolic = systolic;
	}

	public Integer getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
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

		result = (prime * result) + (int) (id ^ (id >>> 32));

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

		final BloodDataItem other = (BloodDataItem) obj;

		return id == other.getId();
	}

	@Override
	public String toString() {
		return "BloodDataItem [idInput=" + id + ", patientIdInput=" + patientId
				+ ", timestampPicker=" + timestamp + ", systolicInput=" + systolic
				+ ", diastolicInput=" + diastolic + ", pulseInput=" + pulse
				+ ", commentInput=" + comment + "]";
	}

}