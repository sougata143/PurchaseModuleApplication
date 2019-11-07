package com.aspl.org.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="goods_receipt_note_header")
public class GoodsRecieptNoteHeader {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer grnId;
	
	private String grnNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdDate;
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
	private String poId;
	private String poType;
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
	private String vendorId;
	private Integer isActive;
	private Integer isAccepted;
	private Integer isAuthorised;
	private String authorisedBy;
	private Date authoriseDate;
	private Integer qcAccept;
	
	private String notes;
	
	private Integer grnStatus;
	
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
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
	public Date getAuthoriseDate() {
		return authoriseDate;
	}
	public void setAuthoriseDate(Date authoriseDate) {
		this.authoriseDate = authoriseDate;
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
	public String getPoId() {
		return poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getPoType() {
		return poType;
	}
	public void setPoType(String poType) {
		this.poType = poType;
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
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
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
	
	public Integer getQcAccept() {
		return qcAccept;
	}
	public void setQcAccept(Integer qcAccept) {
		this.qcAccept = qcAccept;
	}
	public Integer getGrnStatus() {
		return grnStatus;
	}
	public void setGrnStatus(Integer grnStatus) {
		this.grnStatus = grnStatus;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
