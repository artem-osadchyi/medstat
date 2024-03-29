package com.insane.medstat.client.view.impl;

import static com.insane.medstat.shared.constants.BloodDataItemConstants.DIASTOLIC_NAN_MESSAGE;
import static com.insane.medstat.shared.constants.BloodDataItemConstants.PULSE_NAN_MESSAGE;
import static com.insane.medstat.shared.constants.BloodDataItemConstants.SYSTOLIC_NAN_MESSAGE;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.constants.PanelType;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import org.gwtbootstrap3.extras.growl.client.ui.Growl;
import org.gwtbootstrap3.extras.growl.client.ui.GrowlHelper;
import org.gwtbootstrap3.extras.growl.client.ui.GrowlOptions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.validation.client.impl.Validation;
import com.insane.medstat.shared.NotParsableException;
import com.insane.medstat.shared.dto.BloodDataItem;
import com.insane.medstat.shared.service.BloodDataService;
import com.insane.medstat.shared.service.BloodDataServiceAsync;

public class AddBloodDataViewImpl extends Composite {
	private static AddBloodDataViewImplUiBinder uiBinder = GWT
			.create(AddBloodDataViewImplUiBinder.class);

	interface AddBloodDataViewImplUiBinder extends
			UiBinder<Widget, AddBloodDataViewImpl> {
	}

	// TODO: Should be autogenerated
	@UiField
	Input idInput;

	// TODO: Should be returned by security context
	@UiField
	Input patientIdInput;

	@UiField
	DateTimePicker timestampPicker;

	@UiField
	Input systolicInput;

	@UiField
	Input diastolicInput;

	@UiField
	Input pulseInput;

	@UiField
	Input commentInput;

	@UiField
	Button submitButton;

	@UiField
	Panel panel;

	public BloodDataItem toBloodDataItem() throws NotParsableException {
		final BloodDataItem item = new BloodDataItem();

		item.setId(getId());
		item.setPatientId(getPatientId());
		item.setTimestamp(getTimestamp());
		item.setSystolic(getSystolic());
		item.setDiastolic(getDiastolic());
		item.setPulse(getPulse());
		item.setComment(getComment());

		return item;
	}

	BloodDataServiceAsync bds;

	Validator validator;

	public AddBloodDataViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		bds = GWT.create(BloodDataService.class);
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	public long getId() {
		return Long.parseLong(idInput.getValue());
	}

	public long getPatientId() {
		return Long.parseLong(patientIdInput.getValue());
	}

	public Date getTimestamp() {
		return timestampPicker.getValue();
	}

	public int getSystolic() throws NotParsableException {
		try {
			return Integer.parseInt(systolicInput.getValue());
		}
		catch (final Exception e) {
			throw new NotParsableException(SYSTOLIC_NAN_MESSAGE);
		}
	}

	public int getDiastolic() throws NotParsableException {
		try {
			return Integer.parseInt(diastolicInput.getValue());
		}
		catch (final Exception e) {
			throw new NotParsableException(DIASTOLIC_NAN_MESSAGE);
		}
	}

	public int getPulse() throws NotParsableException {
		try {
			return Integer.parseInt(pulseInput.getValue());
		}
		catch (final Exception e) {
			throw new NotParsableException(PULSE_NAN_MESSAGE);
		}
	}

	public String getComment() {
		return commentInput.getValue();
	}

	@UiHandler("submitButton")
	void submit(ClickEvent event) {
		try {
			final BloodDataItem item = toBloodDataItem();
			final Set<ConstraintViolation<BloodDataItem>> violations = validator
					.validate(item);

			for (final ConstraintViolation<BloodDataItem> v : violations) {
				final GrowlOptions go = GrowlHelper.getNewOptions();
				go.setDangerType();
				Growl.growl(v.getMessage(), go);
			}

			bds.add(item, new AsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					panel.setType(PanelType.SUCCESS);
				}

				@Override
				public void onFailure(Throwable caught) {
					panel.setType(PanelType.DANGER);
				}
			});
		}
		catch (final NotParsableException npe) {
			final GrowlOptions go = GrowlHelper.getNewOptions();
			go.setDangerType();
			Growl.growl(npe.getMessage(), go);
		}
	}

}