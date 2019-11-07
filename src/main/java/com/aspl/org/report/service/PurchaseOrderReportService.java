package com.aspl.org.report.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PurchaseOrderReportService {

	Map<String, Object> getPurchaseOrderReport(HttpServletRequest request, String purchaseId);

	/*
	 * Map<String, Object> getroadforwordingnotes(HttpServletRequest request, String
	 * invoice);
	 * 
	 * Map<String, Object> getSubStockistInvoiceReport(HttpServletRequest request,
	 * String profID);
	 */
}
