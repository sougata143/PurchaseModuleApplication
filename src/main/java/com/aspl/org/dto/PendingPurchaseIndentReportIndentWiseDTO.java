package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PendingPurchaseIndentReportIndentWiseDTO {

	private String companyName;
	private String registeredOffcieAddress;
	private String factoryAddress;
	
	private String indentCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date indentDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date indentAuthDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date validityDate;
	
	private String purchaseCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	private Double purchaseQnt;
	private String department;
	
	private String notes;
	
	private String receiptNo;
	private Double receivedQnt;
	
	private List<PendingPurchaseIndentReportIndentWiseItemDetailsDTO> pendingPurchaseIndentReportIndentWiseItemDetailsDTO;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRegisteredOffcieAddress() {
		return registeredOffcieAddress;
	}
	public void setRegisteredOffcieAddress(String registeredOffcieAddress) {
		this.registeredOffcieAddress = registeredOffcieAddress;
	}
	public String getFactoryAddress() {
		return factoryAddress;
	}
	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
	}
	public String getIndentCode() {
		return indentCode;
	}
	public void setIndentCode(String indentCode) {
		this.indentCode = indentCode;
	}
	public Date getIndentDate() {
		return indentDate;
	}
	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}
	public Date getIndentAuthDate() {
		return indentAuthDate;
	}
	public void setIndentAuthDate(Date indentAuthDate) {
		this.indentAuthDate = indentAuthDate;
	}
	public Date getValidityDate() {
		return validityDate;
	}
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}
	
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Double getPurchaseQnt() {
		return purchaseQnt;
	}
	public void setPurchaseQnt(Double purchaseQnt) {
		this.purchaseQnt = purchaseQnt;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public Double getReceivedQnt() {
		return receivedQnt;
	}
	public void setReceivedQnt(Double receivedQnt) {
		this.receivedQnt = receivedQnt;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public List<PendingPurchaseIndentReportIndentWiseItemDetailsDTO> getPendingPurchaseIndentReportIndentWiseItemDetailsDTO() {
		return pendingPurchaseIndentReportIndentWiseItemDetailsDTO;
	}
	public void setPendingPurchaseIndentReportIndentWiseItemDetailsDTO(
			List<PendingPurchaseIndentReportIndentWiseItemDetailsDTO> pendingPurchaseIndentReportIndentWiseItemDetailsDTO) {
		this.pendingPurchaseIndentReportIndentWiseItemDetailsDTO = pendingPurchaseIndentReportIndentWiseItemDetailsDTO;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
