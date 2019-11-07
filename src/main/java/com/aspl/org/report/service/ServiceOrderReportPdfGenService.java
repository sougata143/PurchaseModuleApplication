package com.aspl.org.report.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ServiceOrderReportPdfGenService {

	Map<String, Object> getServiceOrderReport(HttpServletRequest request, String serviceId);

	/*
	 * Map<String, Object> getroadforwordingnotes(HttpServletRequest request, String
	 * invoice);
	 * 
	 * Map<String, Object> getSubStockistInvoiceReport(HttpServletRequest request,
	 * String profID);
	 */
}
