package com.aspl.org.report.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PendingPurchaseOrderItemWiseReportService {

	public Map<String, Object> getInvoiceReport(HttpServletRequest request, String profID);

	/*
	 * Map<String, Object> getroadforwordingnotes(HttpServletRequest request, String
	 * invoice);
	 * 
	 * Map<String, Object> getSubStockistInvoiceReport(HttpServletRequest request,
	 * String profID);
	 */
}
