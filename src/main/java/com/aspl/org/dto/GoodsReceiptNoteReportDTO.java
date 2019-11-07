package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.aspl.org.entity.CompanyMaster;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GoodsReceiptNoteReportDTO {

	private CompanyMaster company;
	
	private String grnNo;
	private String poNo;
	private String invoiceNo;
	private String dcNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date authoriseDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date grnDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date poDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date invoiceDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dcDate;
	private String checkedBy;
	private String preparedBy;
	private String authorisedBy;
	
	private VendorMasterDTO vendorMaster;
	
	private String transport;
	private String notes;
	
	private Double totalChalanQnt;
	private Double totalReceivedQnt;
	private Double totalReceivedWt;
	private Double totalAcceptedQnt;
	private Double totalRejectedQnt;
	
	private List<GoodsReceiptNoteReportItemsDTO> goodsReceiptNoteReportItemsDTO;

	public CompanyMaster getCompany() {
		return company;
	}

	public void setCompany(CompanyMaster company) {
		this.company = company;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getDcNo() {
		return dcNo;
	}

	public void setDcNo(String dcNo) {
		this.dcNo = dcNo;
	}

	public Date getAuthoriseDate() {
		return authoriseDate;
	}

	public void setAuthoriseDate(Date authoriseDate) {
		this.authoriseDate = authoriseDate;
	}

	public Date getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(Date grnDate) {
		this.grnDate = grnDate;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getDcDate() {
		return dcDate;
	}

	public void setDcDate(Date dcDate) {
		this.dcDate = dcDate;
	}

	public String getCheckedBy() {
		return checkedBy;
	}

	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public String getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public VendorMasterDTO getVendorMaster() {
		return vendorMaster;
	}

	public void setVendorMaster(VendorMasterDTO vendorMaster) {
		this.vendorMaster = vendorMaster;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public List<GoodsReceiptNoteReportItemsDTO> getGoodsReceiptNoteReportItemsDTO() {
		return goodsReceiptNoteReportItemsDTO;
	}

	public void setGoodsReceiptNoteReportItemsDTO(List<GoodsReceiptNoteReportItemsDTO> goodsReceiptNoteReportItemsDTO) {
		this.goodsReceiptNoteReportItemsDTO = goodsReceiptNoteReportItemsDTO;
	}

	public Double getTotalChalanQnt() {
		return totalChalanQnt;
	}

	public void setTotalChalanQnt(Double totalChalanQnt) {
		this.totalChalanQnt = totalChalanQnt;
	}

	public Double getTotalReceivedQnt() {
		return totalReceivedQnt;
	}

	public void setTotalReceivedQnt(Double totalReceivedQnt) {
		this.totalReceivedQnt = totalReceivedQnt;
	}

	public Double getTotalReceivedWt() {
		return totalReceivedWt;
	}

	public void setTotalReceivedWt(Double totalReceivedWt) {
		this.totalReceivedWt = totalReceivedWt;
	}

	public Double getTotalAcceptedQnt() {
		return totalAcceptedQnt;
	}

	public void setTotalAcceptedQnt(Double totalAcceptedQnt) {
		this.totalAcceptedQnt = totalAcceptedQnt;
	}

	public Double getTotalRejectedQnt() {
		return totalRejectedQnt;
	}

	public void setTotalRejectedQnt(Double totalRejectedQnt) {
		this.totalRejectedQnt = totalRejectedQnt;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
	
	
}
