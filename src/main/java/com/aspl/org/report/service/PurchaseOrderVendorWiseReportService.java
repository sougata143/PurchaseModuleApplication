package com.aspl.org.report.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PurchaseOrderVendorWiseReportService {

	public Map<String, Object> getPurchaseOrderItemWise(HttpServletRequest request, String itemId, String startDate, String endDate);
	
}
