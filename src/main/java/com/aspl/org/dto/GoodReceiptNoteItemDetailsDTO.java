package com.aspl.org.dto;

import java.util.Date;

import com.aspl.org.entity.UomMaster;
import com.fasterxml.jackson.annotation.JsonFormat;

public class GoodReceiptNoteItemDetailsDTO {

	private Integer grnDetailsId;
	
	private ItemForCategoryMapDTO item;

	private String process;
	
	private UomMaster uomDTO;
	
	private String rateType;
	private Double weight;
	private String batchNo;
	private Double batchQnt;
	private Double availableQnt;
	private Double pendingOrderedQnt;
	private Double price;
	private Double invoiceQnt;
	private Double receivedQnt;
	private Double acceptedQnt;
	private Double rejectedQnt;
	private String reason;
	
	private DepartmentForGRNDTO department;
	private String departmentId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expiryDate;
	
	private PoDetailsDTO poDetails;
	private String grnHeaderId;
	
	private Integer detailsStatus;
	private Integer detailsQcStatus;
	
	private Double wtPerUnit;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date mfgDate;

	private Integer poDetailsId;
	
	public String getGrnHeaderId() {
		return grnHeaderId;
	}

	public void setGrnHeaderId(String grnHeaderId) {
		this.grnHeaderId = grnHeaderId;
	}

	public Integer getGrnDetailsId() {
		return grnDetailsId;
	}

	public void setGrnDetailsId(Integer grnDetailsId) {
		this.grnDetailsId = grnDetailsId;
	}

	public ItemForCategoryMapDTO getItem() {
		return item;
	}

	public void setItem(ItemForCategoryMapDTO item) {
		this.item = item;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	
	public UomMaster getUomDTO() {
		return uomDTO;
	}

	public void setUomDTO(UomMaster uomDTO) {
		this.uomDTO = uomDTO;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Double getBatchQnt() {
		return batchQnt;
	}

	public void setBatchQnt(Double batchQnt) {
		this.batchQnt = batchQnt;
	}

	public Double getAvailableQnt() {
		return availableQnt;
	}

	public void setAvailableQnt(Double availableQnt) {
		this.availableQnt = availableQnt;
	}

	public Double getPendingOrderedQnt() {
		return pendingOrderedQnt;
	}

	public void setPendingOrderedQnt(Double pendingOrderedQnt) {
		this.pendingOrderedQnt = pendingOrderedQnt;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getInvoiceQnt() {
		return invoiceQnt;
	}

	public void setInvoiceQnt(Double invoiceQnt) {
		this.invoiceQnt = invoiceQnt;
	}

	public Double getReceivedQnt() {
		return receivedQnt;
	}

	public void setReceivedQnt(Double receivedQnt) {
		this.receivedQnt = receivedQnt;
	}

	public Double getAcceptedQnt() {
		return acceptedQnt;
	}

	public void setAcceptedQnt(Double acceptedQnt) {
		this.acceptedQnt = acceptedQnt;
	}

	public Double getRejectedQnt() {
		return rejectedQnt;
	}

	public void setRejectedQnt(Double rejectedQnt) {
		this.rejectedQnt = rejectedQnt;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public DepartmentForGRNDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentForGRNDTO department) {
		this.department = department;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public PoDetailsDTO getPoDetails() {
		return poDetails;
	}

	public void setPoDetails(PoDetailsDTO poDetails) {
		this.poDetails = poDetails;
	}

	public Integer getDetailsStatus() {
		return detailsStatus;
	}

	public void setDetailsStatus(Integer detailsStatus) {
		this.detailsStatus = detailsStatus;
	}

	public Integer getDetailsQcStatus() {
		return detailsQcStatus;
	}

	public void setDetailsQcStatus(Integer detailsQcStatus) {
		this.detailsQcStatus = detailsQcStatus;
	}

	public Double getWtPerUnit() {
		return wtPerUnit;
	}

	public void setWtPerUnit(Double wtPerUnit) {
		this.wtPerUnit = wtPerUnit;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Integer getPoDetailsId() {
		return poDetailsId;
	}

	public void setPoDetailsId(Integer poDetailsId) {
		this.poDetailsId = poDetailsId;
	}

	
	
}
