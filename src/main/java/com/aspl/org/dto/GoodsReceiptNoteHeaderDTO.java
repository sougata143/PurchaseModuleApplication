package com.aspl.org.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GoodsReceiptNoteHeaderDTO {

	private Integer grnId;
	private String grnNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date inwardDate;
	private String inwardType;
	private String grnType;
	private String dcNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dcDate;
	private String invoiceNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date invoiceDate;
	private Integer qcRequired;
	
	private POforGRNDTO purchaseOrder;
	private String transporterName;
	private Integer rgWt;
	
	
	private String lrNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date lrDate;
	private String vehicleNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date receivedOn;
	private Double grossWeight;
	private Double tareWeight;
	private Double netWeight;
	private String supplierTc;
	private Integer isActive;
	private Integer isAccepted;
	private Integer isAuthorised;
	private String authorisedBy;
	private String qcAccept;
	
	private Integer grnStatus;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createDate;
	private Date authDate;
	private String vendorId;
	private String vendorName;
	
	private String notes;
	
	private List<GoodReceiptNoteItemDetailsDTO> goodReceiptNoteItemDetails;

	public Integer getGrnId() {
		return grnId;
	}

	public void setGrnId(Integer grnId) {
		this.grnId = grnId;
	}

	public String getGrnNo() {
		return grnNo;
	}

	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public String getInwardType() {
		return inwardType;
	}

	public void setInwardType(String inwardType) {
		this.inwardType = inwardType;
	}

	public String getGrnType() {
		return grnType;
	}

	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}

	public String getDcNo() {
		return dcNo;
	}

	public void setDcNo(String dcNo) {
		this.dcNo = dcNo;
	}

	public Date getDcDate() {
		return dcDate;
	}

	public void setDcDate(Date dcDate) {
		this.dcDate = dcDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Integer getQcRequired() {
		return qcRequired;
	}

	public void setQcRequired(Integer qcRequired) {
		this.qcRequired = qcRequired;
	}

	public POforGRNDTO getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(POforGRNDTO purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public Integer getRgWt() {
		return rgWt;
	}

	public void setRgWt(Integer rgWt) {
		this.rgWt = rgWt;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public Date getLrDate() {
		return lrDate;
	}

	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Date getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}

	public Double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public Double getTareWeight() {
		return tareWeight;
	}

	public void setTareWeight(Double tareWeight) {
		this.tareWeight = tareWeight;
	}

	public Double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}

	public String getSupplierTc() {
		return supplierTc;
	}

	public void setSupplierTc(String supplierTc) {
		this.supplierTc = supplierTc;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Integer isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Integer getIsAuthorised() {
		return isAuthorised;
	}

	public void setIsAuthorised(Integer isAuthorised) {
		this.isAuthorised = isAuthorised;
	}

	public String getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public String getQcAccept() {
		return qcAccept;
	}

	public void setQcAccept(String qcAccept) {
		this.qcAccept = qcAccept;
	}

	public Integer getGrnStatus() {
		return grnStatus;
	}

	public void setGrnStatus(Integer grnStatus) {
		this.grnStatus = grnStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public List<GoodReceiptNoteItemDetailsDTO> getGoodReceiptNoteItemDetails() {
		return goodReceiptNoteItemDetails;
	}

	public void setGoodReceiptNoteItemDetails(List<GoodReceiptNoteItemDetailsDTO> goodReceiptNoteItemDetails) {
		this.goodReceiptNoteItemDetails = goodReceiptNoteItemDetails;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
}
