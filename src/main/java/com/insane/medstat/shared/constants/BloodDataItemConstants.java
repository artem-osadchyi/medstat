package com.insane.medstat.shared.constants;

public class BloodDataItemConstants {
	public static final String ID_NULL_MESSAGE = "ID may not be null";
	public static final String PATIENT_ID_NULL_MESSAGE = "Patient ID may not be null";
	public static final String TIMESTAMP_FUTURE_MESSAGE = "Timestamp must be in the past";
	public static final String TIMESTAMP_NULL_MESSAGE = "Timestamp may not be null";
	public static final String SYSTOLIC_NAN_MESSAGE = "Systolic must be a number";
	public static final String SYSTOLIC_LOW_MESSAGE = "Systolic must be greater than or equal to {value}";
	public static final String SYSTOLIC_HIGH_MESSAGE = "Systolic must be less than or equal to {value}";
	public static final String DIASTOLIC_NAN_MESSAGE = "Diastolic must be a number";
	public static final String DIASTOLIC_LOW_MESSAGE = "Diastolic must be greater than or equal to {value}";
	public static final String DIASTOLIC_HIGH_MESSAGE = "Diastolic must be less than or equal to {value}";
	public static final String PULSE_NAN_MESSAGE = "Pulse must be a number";
	public static final String PULSE_LOW_MESSAGE = "Pulse must be greater than or equal to {value}";
	public static final String PULSE_HIGH_MESSAGE = "Pulse must be less than or equal to {value}";
	public static final String COMMENT_MATCH_MESSAGE = "Comment contains wrong characters";
	public static final String COMMENT_SIZE_MESSAGE = "Comment size must be between {min} and {max}";
	public static final int MIN_SYSTOLIC_VALUE = 0;
	public static final int MAX_SYSTOLIC_VALUE = 300;
	public static final int MIN_DIASTOLIC_VALUE = 0;
	public static final int MAX_DIASTOLIC_VALUE = 300;
	public static final int MIN_PULSE_VALUE = 0;
	public static final int MAX_PULSE_VALUE = 300;
	public static final String COMMENT_PATTERN = "\\w+";
	public static final int MIN_COMMENT_SIZE = 1;
	public static final int MAX_COMMENT_SIZE = 300;
}