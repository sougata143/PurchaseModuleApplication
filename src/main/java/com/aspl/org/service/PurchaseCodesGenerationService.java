package com.aspl.org.service;

public interface PurchaseCodesGenerationService {

	public String generatePurchaseOrderCode();
	public String generateIndentCode();
	public String generateGrnCode();
	public String generateServiceOrderCode();
	public String generateItemCode(String categoryName);
	public String generateVendorCode();
	
	
}
