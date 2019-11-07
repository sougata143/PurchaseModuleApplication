package com.aspl.org.service;

import java.text.ParseException;
import java.util.List;

import com.aspl.org.dto.GoodsReceiptNoteReportDTO;
import com.aspl.org.dto.PendingPurchaseIndentReportIndentWiseDTO;
import com.aspl.org.dto.PurchaseIndentReportDTO;
import com.aspl.org.dto.PurchaseOrderReportDTO;


public interface PurchaseReportService {

	List<PendingPurchaseIndentReportIndentWiseDTO> getPendingPurchaseIndentReportIndentWiseDTO(String startDate, String endDate) throws ParseException;
	
	List<PendingPurchaseIndentReportIndentWiseDTO> getPendingPurchaseOrderOfIndentReportIndentWiseDTO(String startDate, String endDate) throws ParseException;
	
	GoodsReceiptNoteReportDTO getGoodsReceiptNoteReport(Integer grnId);
	
	List<GoodsReceiptNoteReportDTO> getPendingGoodsReturnReport(String startDate, String endDate);

	List<PendingPurchaseIndentReportIndentWiseDTO> getAllPurchaseIndentReportIndentWise(String startDate,String endDate) throws ParseException;

	PurchaseIndentReportDTO getPurchaseIndentReport(Integer indentId);

	PurchaseOrderReportDTO getPurchaseOrderReport(Integer purchaseId);
	List<PurchaseOrderReportDTO> getPendingPurchaseOrderReportVendorWise(String startDate, String endDate, Integer vendorId);
	List<PurchaseOrderReportDTO> getPurchaseOrderReportItemWise(String startDate, String endDate, Integer itemId);
	
}
