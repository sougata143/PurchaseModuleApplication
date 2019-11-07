package com.aspl.org.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspl.org.dto.GoodsReceiptNoteReportDTO;
import com.aspl.org.dto.StockLedgerDTO;
import com.aspl.org.report.service.AllPurchaseIndnetReportService;
import com.aspl.org.report.service.NoPurchaseOrderOfAuthorisedIndnetReportService;
import com.aspl.org.report.service.PendingPurchaseIndnetReportService;
import com.aspl.org.report.service.PurchaseGoodReceiptNoteReportService;
import com.aspl.org.report.service.PurchaseIndnetReportService;
import com.aspl.org.report.service.PurchaseOrderItemWiseReportService;
import com.aspl.org.report.service.PurchaseOrderReportService;
import com.aspl.org.report.service.PurchaseOrderVendorWiseReportService;
import com.aspl.org.service.PurchaseReportService;
import com.aspl.org.service.StockLedgerReportService;

@RestController
@RequestMapping("purchaseReport/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchasReportController {

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@Autowired
	PurchaseIndnetReportService indentReport;
	
	@Autowired
	PurchaseOrderReportService purchaseOrderReport;
	
	@Autowired
	PendingPurchaseIndnetReportService pendingPurchaseIndnetReportService;
	
	@Autowired
	AllPurchaseIndnetReportService allPurchaseIndnetReportService;
	
	@Autowired
	PurchaseOrderReportService purchaseOrderReportService;

	@Autowired
	PurchaseOrderItemWiseReportService purchaseOrderitemWiseReport;
	
	@Autowired
	PurchaseOrderVendorWiseReportService purchaseOrdervendorWiseReport;
	
	@Autowired
	PurchaseGoodReceiptNoteReportService grnReportService;
	
	@Autowired
	NoPurchaseOrderOfAuthorisedIndnetReportService noPurchaseOrderOfAuthorisedIndnetReportService;
	
	@Autowired
	StockLedgerReportService stockLedgerReportService;
	
	
	
	
	
	@GetMapping("pendingPurchaseOrderOfAuthorisedIndentReportIndentWiseReport/{startDate}/{endDate}")
	public Map<String, Object> getPendingPurchaseOrderOfIndentReportIndentWiseDTO(HttpServletRequest request, 
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws ParseException{
		
		return noPurchaseOrderOfAuthorisedIndnetReportService.NoPurchaseOrderOfAuthorisedIndnetReport(request, startDate, endDate);
		
	}
	
	
	@GetMapping("pendingPurchaseIndentReportIndentWiseReport/{startDate}/{endDate}")
	public Map<String, Object> getPendingPurchaseIndentReportIndentWise(HttpServletRequest request, 
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws ParseException{
		
		return pendingPurchaseIndnetReportService.getInvoiceReport(request, startDate, endDate);
		
	}
	
	@GetMapping("goodsReceiptNoteReport/{grnId}")
	public Map<String, Object> getGoodsReceiptNoteReport(HttpServletRequest request, @PathVariable("grnId") String grnId) {
		return grnReportService.getPurchaseGoodReceiptNoteReport(request, grnId);
	}
	
	@GetMapping("pendingGoodsReturnReport/{startDate}/{endDate}")
	public List<GoodsReceiptNoteReportDTO> getPendingGoodsReturnReport(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
		return purchaseReportService.getPendingGoodsReturnReport(startDate, endDate);
	}
	
	@GetMapping("allPurchaseIndentSummaryReport/{startDate}/{endDate}")
	public Map<String, Object> getAllPurchaseIndentReportIndentWise(HttpServletRequest request,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws ParseException{
		return allPurchaseIndnetReportService.getInvoiceReport(request, startDate, endDate);
	}
	
//	@GetMapping("purchaseIndentPendingReportItemWise/{")
//	public List<PurchaseIndentPendingReportDTO> getPurchasreIndentPendingReport()
	
	@GetMapping("purchaseIndentReport/{indentId}")
	public Map<String, Object> getPurchaseIndentReport(HttpServletRequest request, @PathVariable("indentId") String indentId) {
		return indentReport.getInvoiceReport(request, indentId);
	}
	
	@GetMapping("purchaseOrderReport/{purchaseId}")
	public Map<String, Object> getPurchaseOrderReport(HttpServletRequest request, @PathVariable("purchaseId") String purchaseId) {
		return purchaseOrderReport.getPurchaseOrderReport(request, purchaseId);
	}
	
	@GetMapping("purchaseOrderReportItemWise/{itemId}/{startDate}/{endDate}")
	public Map<String, Object> getPurchaseOrderReportItemWise(HttpServletRequest request, @PathVariable("itemId") String itemId,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
		return purchaseOrderitemWiseReport.getPurchaseOrderItemWise(request, itemId, startDate, endDate);
	}
	
	@GetMapping("purchaseOrderReportVendorWise/{vendorId}/{startDate}/{endDate}")
	public Map<String, Object> getPurchaseOrderReportVendorWise(HttpServletRequest request, @PathVariable("vendorId") String vendorId,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
		return purchaseOrdervendorWiseReport.getPurchaseOrderItemWise(request, vendorId, startDate, endDate);
	}
	
	@RequestMapping(value = "/downloadReport/{fileName:.+}", method = RequestMethod.GET, produces = "application/pdf")
	 public ResponseEntity<InputStreamResource> download(@PathVariable("fileName") String fileName) throws IOException {
		  
		  ClassPathResource pdfFile = new ClassPathResource("src/main/resources/pdf/" + fileName);
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.parseMediaType("application/pdf"));
		  headers.add("Access-Control-Allow-Origin", "*");
		  headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
		  headers.add("Access-Control-Allow-Headers", "Content-Type");
		  headers.add("Content-Disposition", "filename=" + fileName);
		  headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		  headers.add("Pragma", "no-cache");
		  headers.add("Expires", "0");
		 
		  headers.setContentLength(pdfFile.contentLength());
		  ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
		    new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
		  return response;
	 
	 }
	
	@GetMapping("stockLedgerReport/{itemId}")
	public StockLedgerDTO getStockLedgerReport(HttpServletRequest request, @PathVariable("itemId") String itemId) {
		return stockLedgerReportService.getStockLedgerReport(Integer.valueOf(itemId));
	}
	
}
