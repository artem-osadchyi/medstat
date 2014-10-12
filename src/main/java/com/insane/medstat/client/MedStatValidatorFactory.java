package com.insane.medstat.client;

import javax.validation.Validator;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.insane.medstat.shared.dto.BloodDataItem;

public class MedStatValidatorFactory extends AbstractGwtValidatorFactory {

	@GwtValidation(BloodDataItem.class)
	public interface BloodDataItemValidator extends Validator {
	}

	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(BloodDataItemValidator.class);
	}

}