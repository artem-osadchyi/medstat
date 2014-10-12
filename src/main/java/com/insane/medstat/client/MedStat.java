package com.insane.medstat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.insane.medstat.client.view.impl.AddBloodDataViewImpl;
import com.insane.medstat.client.view.impl.BloodDataTextViewImpl;

public class MedStat implements EntryPoint {

	public void onModuleLoad() {
		RootPanel.get().add(new AddBloodDataViewImpl());
		// RootPanel.get().add(new BloodDataTextViewImpl("Click it"));
	}

}