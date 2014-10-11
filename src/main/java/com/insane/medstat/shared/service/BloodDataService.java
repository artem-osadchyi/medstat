package com.insane.medstat.shared.service;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.insane.medstat.shared.dto.BloodDataItem;

@RemoteServiceRelativePath("service/blood")
public interface BloodDataService extends RemoteService {

	void add(BloodDataItem item);

	ArrayList<BloodDataItem> get(Long patientId, Date start, Date end);

}