package com.insane.medstat.shared;

import java.io.Serializable;

public class NotParsableException extends Exception implements Serializable {

	public NotParsableException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 7135445459320500385L;

}