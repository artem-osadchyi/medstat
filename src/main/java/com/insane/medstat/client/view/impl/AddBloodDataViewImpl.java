package com.insane.medstat.client.view.impl;

import java.util.Date;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.constants.PanelType;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.insane.medstat.client.view.AddBloodDataView;
import com.insane.medstat.shared.dto.BloodDataItem;
import com.insane.medstat.shared.service.BloodDataService;
import com.insane.medstat.shared.service.BloodDataServiceAsync;

public class AddBloodDataViewImpl extends Composite implements AddBloodDataView {

	private static AddBloodDataViewImplUiBinder uiBinder = GWT
			.create(AddBloodDataViewImplUiBinder.class);

	interface AddBloodDataViewImplUiBinder extends
			UiBinder<Widget, AddBloodDataViewImpl> {
	}

	@UiField
	Input id;

	@UiField
	Input patient;

	@UiField
	DateTimePicker timestamp;

	@UiField
	Input sbp;

	@UiField
	Input dbp;

	@UiField
	Input pulse;

	@UiField
	Input comment;

	@UiField
	Button submit;

	@UiField
	Panel panel;

	BloodDataServiceAsync bds;

	public AddBloodDataViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		bds = GWT.create(BloodDataService.class);
	}

	public long getId() {
		return Long.parseLong(id.getValue());
	}

	public long getPatientId() {
		return Long.parseLong(patient.getValue());
	}

	public Date getTime() {
		return timestamp.getValue();
	}

	public int getSystolic() {
		return Integer.parseInt(sbp.getValue());
	}

	public int getDiastolic() {
		return Integer.parseInt(dbp.getValue());
	}

	public int getPulse() {
		return Integer.parseInt(pulse.getValue());
	}

	public String getComment() {
		return comment.getValue();
	}

	@UiHandler("submit")
	void submit(ClickEvent event) {
		BloodDataItem item = new BloodDataItem();

		item.setId(getId());
		item.setPatientId(getPatientId());
		item.setSystolic(getSystolic());
		item.setDiastolic(getDiastolic());
		item.setPulse(getPulse());
		item.setComment(getComment());

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

}